@ REM Cleans up Docker container and images.

docker container rm wda
docker image rm wda:1-SNAPSHOT
docker image prune --force