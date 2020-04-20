#!/usr/bin/env bash

SCRIPT=${1:-quoteforms}
HOST=${2:-localhost}
PORT=${3:-8080}
THREADS=${4:-8}
REQUEST=${5:-200}
TARGET_DIR=../../../target/

echo Deleting previous executions
rm ${TARGET_DIR}/${SCRIPT}.jtl
rm ${TARGET_DIR}/${SCRIPT}.log
rm -rf ${TARGET_DIR}/${SCRIPT}-report

echo Ejecutando ${SCRIPT} en  ${HOST}:${PORT} con $THREADS hilos y $REQUEST peticions por hilo ...

mkdir -v -p ${TARGET_DIR}/${SCRIPT}-report
jmeter -n -t ${SCRIPT}.jmx -JHOST=${HOST} -JPORT=${PORT} -JTHREAD=${THREADS} -JREQUEST=${REQUEST} \
 -l ${TARGET_DIR}/${SCRIPT}.jtl  -e -o ${TARGET_DIR}/${SCRIPT}-report -j ${TARGET_DIR}/${SCRIPT}.log

echo Todo ejecutado correctamente. Comprueba el resultado en  ${TARGET_DIR}/${SCRIPT}-report
