// src/config/keycloak.ts
import { useAuthStore } from '../stores/auth'

// ── Configuración ──────────────────────────────────────
const KC_URL    = import.meta.env.VITE_KEYCLOAK_URL
const KC_REALM  = import.meta.env.VITE_KEYCLOAK_REALM
const KC_CLIENT = import.meta.env.VITE_KEYCLOAK_CLIENT

const tokenEndpoint  = `${KC_URL}/realms/${KC_REALM}/protocol/openid-connect/token`
const logoutEndpoint = `${KC_URL}/realms/${KC_REALM}/protocol/openid-connect/logout`

// ── Keys de localStorage ───────────────────────────────
const TOKEN_KEY = 'tree-prunning-token'
const REFRESH_KEY = 'tree-prunning-refresh-token'
const USER_KEY  = 'tree-prunning-user'

// ── Refresh timer ──────────────────────────────────────
let _refreshTimer: ReturnType<typeof setTimeout> | null = null

function scheduleRefresh(expiresInSeconds: number) {
  if (_refreshTimer) clearTimeout(_refreshTimer)
  const delay = (expiresInSeconds - 30) * 1000
  _refreshTimer = setTimeout(() => keycloakClient.updateToken(), delay)
}

// ── Inicialización (se llama en main.ts) ───────────────
export async function initializeKeycloak() {
  const authStore = useAuthStore()
  const persistedToken   = localStorage.getItem(TOKEN_KEY)
  const persistedUser    = localStorage.getItem(USER_KEY)
  const persistedRefresh = localStorage.getItem(REFRESH_KEY)

  if (persistedToken && persistedRefresh) {
    authStore.setSession({
      token:        persistedToken,
      refreshToken: persistedRefresh,
      user:         persistedUser ? JSON.parse(persistedUser) : null,
    })

    // Intenta refrescar el token al recargar para verificar que sigue válido
    await keycloakClient.updateToken()
  }
}

// ── Cliente Keycloak ───────────────────────────────────
export const keycloakClient = {

  async login(credentials: { username: string; password: string }) {
    const response = await fetch(tokenEndpoint, {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body: new URLSearchParams({
        grant_type: 'password',
        client_id:  KC_CLIENT,
        username:   credentials.username,
        password:   credentials.password,
      }),
    })

    if (!response.ok) {
      const err = await response.json()
      return { success: false, message: mapError(err.error) }
    }

    const data = await response.json()
    const user = parseJwt(data.access_token)

    // Persiste en localStorage
    localStorage.setItem(TOKEN_KEY,   data.access_token)
    localStorage.setItem(REFRESH_KEY, data.refresh_token)
    localStorage.setItem(USER_KEY,    JSON.stringify(user))

    // Actualiza el store
    const authStore = useAuthStore()
    authStore.setSession({ token: data.access_token, refreshToken: data.refresh_token, user })

    scheduleRefresh(data.expires_in)

    return { success: true }
  },

  async logout() {
    const authStore = useAuthStore()

    // Invalida el token en Keycloak
    const refreshToken = localStorage.getItem(REFRESH_KEY)
    if (refreshToken) {
      await fetch(logoutEndpoint, {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: new URLSearchParams({
          client_id:     KC_CLIENT,
          refresh_token: refreshToken,
        }),
      }).catch(() => {})
    }

    // Limpia timer, store y localStorage
    if (_refreshTimer) clearTimeout(_refreshTimer)
    localStorage.removeItem(TOKEN_KEY)
    localStorage.removeItem(REFRESH_KEY)
    localStorage.removeItem(USER_KEY)
    authStore.clearSession()
  },

  async updateToken(): Promise<boolean> {
    const refreshToken = localStorage.getItem(REFRESH_KEY)
    if (!refreshToken) return false

    try {
      const response = await fetch(tokenEndpoint, {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: new URLSearchParams({
          grant_type:    'refresh_token',
          client_id:     KC_CLIENT,
          refresh_token: refreshToken,
        }),
      })

      if (!response.ok) {
        await keycloakClient.logout()
        return false
      }

      const data = await response.json()
      const user = parseJwt(data.access_token)

      localStorage.setItem(TOKEN_KEY,   data.access_token)
      localStorage.setItem(REFRESH_KEY, data.refresh_token)
      localStorage.setItem(USER_KEY,    JSON.stringify(user))

      const authStore = useAuthStore()
      authStore.setSession({ token: data.access_token, refreshToken: data.refresh_token, user })

      scheduleRefresh(data.expires_in)
      return true

    } catch {
      await keycloakClient.logout()
      return false
    }
  },
}

// ── Helpers ────────────────────────────────────────────
function parseJwt(jwt: string) {
  const base64 = jwt.split('.')[1].replace(/-/g, '+').replace(/_/g, '/')
  return JSON.parse(atob(base64))
}

function mapError(error: string): string {
  const messages: Record<string, string> = {
    'invalid_grant':       'Usuario o contraseña incorrectos.',
    'unauthorized_client': 'Cliente no autorizado.',
    'invalid_client':      'Configuración de cliente inválida.',
  }
  return messages[error] ?? 'Error de autenticación.'
}
