# ── TreePruning · Arranque local ───────────────────────────────────────────────
# Uso:
#   .\start-local.ps1          # primera vez o tras cambios en el backend
#   .\start-local.ps1 -NoBuild # reusar imagen ya construida (más rápido)
# ───────────────────────────────────────────────────────────────────────────────
param(
    [switch]$NoBuild
)

$Root     = $PSScriptRoot
$Frontend = Join-Path $Root "frontend"
$Cyan     = 'Cyan'
$Green    = 'Green'
$Yellow   = 'Yellow'
$Red      = 'Red'

function Write-Step($msg) { Write-Host "`n▶ $msg" -ForegroundColor $Cyan }
function Write-Ok($msg)   { Write-Host "  ✓ $msg" -ForegroundColor $Green }
function Write-Warn($msg) { Write-Host "  ⚠ $msg" -ForegroundColor $Yellow }
function Write-Err($msg)  { Write-Host "  ✗ $msg" -ForegroundColor $Red }

# ── 1. Verificar Docker ────────────────────────────────────────────────────────
Write-Step "Verificando Docker..."
if (-not (Get-Command docker -ErrorAction SilentlyContinue)) {
    Write-Err "Docker no está instalado o no está en el PATH."
    exit 1
}
docker info 2>&1 | Out-Null
if ($LASTEXITCODE -ne 0) {
    Write-Err "Docker no está corriendo. Ábrelo e intenta de nuevo."
    exit 1
}
Write-Ok "Docker activo."

# ── 2. Levantar PostgreSQL + Backend ──────────────────────────────────────────
Write-Step "Levantando PostgreSQL + Backend..."
Push-Location $Root

if ($NoBuild) {
    docker compose up -d
} else {
    Write-Warn "Primera vez: construyendo imagen del backend (puede tardar 3-8 min)..."
    docker compose up -d --build
}

if ($LASTEXITCODE -ne 0) {
    Write-Err "Falló docker compose. Revisa los logs con: docker compose logs"
    Pop-Location
    exit 1
}
Write-Ok "Contenedores iniciados."

# ── 3. Esperar que el backend responda ────────────────────────────────────────
Write-Step "Esperando que el backend esté listo en :8080..."
$timeout  = 120
$elapsed  = 0
$interval = 5
$ready    = $false

while ($elapsed -lt $timeout) {
    Start-Sleep -Seconds $interval
    $elapsed += $interval
    try {
        $r = Invoke-WebRequest -Uri "http://localhost:8080/actuator/health" `
                               -UseBasicParsing -TimeoutSec 3 -ErrorAction Stop
        if ($r.StatusCode -eq 200) { $ready = $true; break }
    } catch {
        try {
            Invoke-WebRequest -Uri "http://localhost:8080" `
                              -UseBasicParsing -TimeoutSec 3 -ErrorAction Stop | Out-Null
            $ready = $true; break
        } catch { <# sigue esperando #> }
    }
    Write-Host "  ... ${elapsed}s / ${timeout}s" -ForegroundColor DarkGray
}

if (-not $ready) {
    Write-Warn "El backend no respondió en ${timeout}s. Puede que aún esté iniciando."
    Write-Warn "Revisa con: docker compose logs backend"
} else {
    Write-Ok "Backend listo."
}

# ── 4. Instalar dependencias del frontend ─────────────────────────────────────
Write-Step "Instalando dependencias del frontend..."
Push-Location $Frontend
if (-not (Test-Path "node_modules")) {
    npm install --silent
    if ($LASTEXITCODE -ne 0) {
        Write-Err "npm install falló."
        Pop-Location; Pop-Location
        exit 1
    }
}
Write-Ok "Dependencias listas."

# ── 5. Iniciar servidor de desarrollo ─────────────────────────────────────────
Write-Step "Iniciando servidor de desarrollo Vue (Vite)..."
Write-Host ""
Write-Host "  ┌─────────────────────────────────────────────────┐" -ForegroundColor Cyan
Write-Host "  │  Frontend  →  http://localhost:5173             │" -ForegroundColor Cyan
Write-Host "  │  Backend   →  http://localhost:8080             │" -ForegroundColor Cyan
Write-Host "  │  (Kong vive en Azure, no se levanta en local)   │" -ForegroundColor Cyan
Write-Host "  └─────────────────────────────────────────────────┘" -ForegroundColor Cyan
Write-Host ""
Write-Host "  Ctrl+C para detener el frontend." -ForegroundColor DarkGray
Write-Host "  Para detener la infra: docker compose down" -ForegroundColor DarkGray
Write-Host ""

npm run dev

Pop-Location
Pop-Location
