# Champions Predictor — Laboratorio 05, Pregunta 1

Aplicación web en **Java 25 (LTS) + Spring Boot + Thymeleaf + PostgreSQL**, arquitectura de tres capas, datos simulados y Docker Compose.

## Requisitos
- Docker Desktop (motor Docker + Compose)
- Para ejecución sin Docker: JDK 25, Maven y PostgreSQL 16

## Ejecutar desde Visual Studio Code
1. Descomprime este ZIP y abre la carpeta `champions-predictor` en VS Code.
2. Instala la extensión **Extension Pack for Java** (opcional para editar Java).
3. Inicia Docker Desktop.
4. Abre la terminal integrada en la carpeta del proyecto.
5. Ejecuta `docker compose up --build -d`.
6. Abre **http://localhost:8080**. El primer arranque puede tardar varios minutos por la descarga y compilación.
7. Para revisar logs: `docker compose logs -f app`. Para detener: `docker compose down`.

**Importante:** No abras `index.html` directamente ni uses Live Server: es una plantilla Thymeleaf que requiere el backend Java.

## Ejecutar Java desde VS Code sin contenedor de app
Primero levanta la base: `docker compose up -d db`. Después ejecuta `mvn spring-boot:run` con JDK 25 y Maven instalados. El archivo `application.properties` ya tiene conexión local de desarrollo a PostgreSQL.

## Persistencia
El volumen `postgres_data` conserva los partidos y predicciones. `docker compose down` NO elimina el volumen; `docker compose down -v` SÍ lo elimina.

## API simulada
`MatchService.fetchSimulatedApi()` simula la respuesta de una API pública. En cada inicio importa seis partidos ficticios, evitando duplicados mediante `externalId`.

## Variables de entorno
Copia `.env.example` a `.env` y cambia `POSTGRES_PASSWORD` por una contraseña segura antes de desplegar en un servidor. No subas `.env` a GitHub.

## Imagen en Docker Hub (requiere cuenta)
```bash
docker login
docker build -t TU_USUARIO/champions-predictor:1.0 .
docker push TU_USUARIO/champions-predictor:1.0
```
En `docker-compose.yml`, la variable `APP_IMAGE` permite elegir esa imagen; para usarla sin compilar, retira `build: .` del servicio `app`.

## AWS
**No usar Amplify Hosting para este ZIP**: es un servicio Java con base PostgreSQL. Para una práctica con Docker Compose se puede usar una instancia EC2 Linux con Docker instalado, reglas de firewall limitadas y un disco persistente; copiar el proyecto y ejecutar `docker compose up --build -d`. Se debe abrir el puerto 8080 solo para pruebas controladas o usar un reverse proxy HTTPS en producción. EC2, almacenamiento y transferencia pueden generar costos. Configura alertas de facturación y elimina recursos al terminar.

## Evidencias sugeridas
1. Página de partidos, formulario de predicción e historial.
2. Terminal `docker compose ps` mostrando `app` y `db` activos.
3. `docker volume ls` y predicciones que sobreviven a `docker compose down` / `up`.
4. Docker Hub mostrando la imagen publicada.
5. URL pública en AWS y capturas de la consola.

Consulta `docs/ARQUITECTURA.md` para el diagrama y el flujo de datos.
