JMeter test
------------
Para lanzar los test hay un script: `runner.sh`
Este script tiene 2 precondiciones:

1. Jmeter en el path
2. EL directorio de trabajo es src/test/jmeter/

El script recibe 5 parámetros:

1. Script. El nombre _jmx script_ que será ejecutado. Por defecto : oauth-server.jmx
2. Host. El host de la aplicación para probar. Por defecto : localhost
3. Port. El puerto de la aplicación para probar. Por defecto : 9999
4. Threads. Número de hilos que se ejecutarán. Por defecto : 4
5. Peticiones por hilo. El número de peticiones por cada hilo que se ejecute. Por defecto: 200

Por defecto el script lanzará oauth-server.jmx en localhost:9999 con 4 hilos y 200 peticiones por hilo.

For example :
```bash
./runner.sh oauth-server localhost 8080 32 5000
```

Lanza el script de jmeter con el script oauth-server en localhost:8080 con 32 hilos y 5000 peticiones por usuario.

Los resultados en html se almacenan en `${TARGET_DIR}/${SCRIPT}-report`
