do the changes in the file and the run the docker file for Dockerfile commited.

>docker build --build-arg url=https://github.com/pravinaec/RedisPoc.git --build-arg project=RedisPoc --build-arg artifactid=spring-RedisServer  --build-arg version=1.0 -t pravisin/springredisserver .

how to run :>>docker run --name redisPOCRest -ti -p 8080:8080 pravisin/springredisserver:latest
