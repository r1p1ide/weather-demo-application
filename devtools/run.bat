@ REM Runs locally a new container.

docker run -p 8080:8080 --name wda -it wda:1-SNAPSHOT

docker container rm wda