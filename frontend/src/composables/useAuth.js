const AUTH_KEY = 'tp_authenticated'

export function useAuth() {
  const isAuthenticated = () => !!localStorage.getItem(AUTH_KEY)
  const login = () => localStorage.setItem(AUTH_KEY, '1')
  const logout = () => localStorage.removeItem(AUTH_KEY)
  return { isAuthenticated, login, logout }
}
