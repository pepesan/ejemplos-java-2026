#!/usr/bin/env bash
# Levanta los contenedores MySQL y phpMyAdmin en segundo plano
set -euo pipefail
cd "$(dirname "$0")"
docker compose up -d
echo "MySQL    → localhost:3306  (root/root, base: cursodb)"
echo "phpMyAdmin → http://localhost:8080"
