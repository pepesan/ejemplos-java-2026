#!/usr/bin/env bash
# Ejecuta un fichero SQL dentro del contenedor MySQL
# Uso: ./06-exec-sql.sh <fichero.sql> [base_de_datos]
set -euo pipefail

if [ $# -lt 1 ]; then
    echo "Uso: $0 <fichero.sql> [base_de_datos]"
    exit 1
fi

SQL_FILE="$1"
DATABASE="${2:-cursodb}"

if [ ! -f "$SQL_FILE" ]; then
    echo "Error: fichero '$SQL_FILE' no encontrado."
    exit 1
fi

docker exec -i cursojava_mysql \
    mysql -uroot -proot "$DATABASE" < "$SQL_FILE"

echo "Script '$SQL_FILE' ejecutado en la base de datos '$DATABASE'."
