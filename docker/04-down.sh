#!/usr/bin/env bash
# Para y elimina los contenedores y el volumen de datos
set -euo pipefail
cd "$(dirname "$0")"
docker compose down -v
echo "Contenedores eliminados y volumen borrado."
