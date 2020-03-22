do the changes in the file
RedisClusterUtility.java --> change cluster_url=<CLuster_URLs>
eg. cluster_url = "redis://kkm00cya.in.oracle.com:6379, redis://kkm00aot.in.oracle.com:6380,redis://blr00bfm.in.oracle.com:6381";
and then run the dockerfile for Dockerfile file commited.

>docker build --build-arg url=https://github.com/pravinaec/RedisPoc.git --build-arg project=RedisPoc --build-arg artifactid=spring-   RedisServer  --build-arg version=1.0 -t pravisin/springredisserver .

how to run :>>docker run --name redisPOCRest -ti -p 8080:8080 pravisin/springredisserver:latest
