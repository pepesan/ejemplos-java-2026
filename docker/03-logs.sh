#!/usr/bin/env bash
# Muestra los logs en tiempo real (Ctrl+C para salir)
set -euo pipefail
cd "$(dirname "$0")"
docker compose logs -f
