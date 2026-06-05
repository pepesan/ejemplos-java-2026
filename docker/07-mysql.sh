#!/usr/bin/env bash
# Abre el cliente mysql interactivo en la base de datos indicada
# Uso: ./07-mysql.sh [base_de_datos]
set -euo pipefail

DATABASE="${1:-cursodb}"

docker exec -it cursojava_mysql \
    mysql -uroot -proot "$DATABASE"
