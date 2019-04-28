# Qproj4MP

## Quarking a generated MicroProfile project

This is a demonstration project that consists of 2 projects illustrating MicroProfile 2.2 features.
This project depends on KeyCloak for the MP-JWT token generation. To launch Keycloak in a docker
container run:

```bash
docker run -d --name keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8180:8180 -v `pwd`/demo-realm.json:/config/quarkus-kc-quickstart.json -it jboss/keycloak:6.0.1 -b 0.0.0.0 -Djboss.http.port=8180 -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.file=/config/quarkus-kc-quickstart.json -Dkeycloak.migration.strategy=OVERWRITE_EXISTING
```

This project depends on Jaeger for the collection of the MP OpenTracing information. To launch
the Jaeger tracing system in a docker container run: 
```bash
docker run -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 jaegertracing/all-in-one:latest
```

Note: The contents of the src directory of this project came from generating an MP 2.1 project for Thorntail V2 using the [MicroProfile Starter](https://start.microprofile.io).

First, clone this project to your Mac, build it by changing directory to it and then running this command to exexute the application in development mode:

./mvnw compile quarkus:dev

Once application is up and running, point your browser to:

http://localhost:8080/index.html

### Generating an executable JAR

To generate the standalone executable JAR file, run the following from the command line:

./mvn clean package

Once the build is finished, to run the jar, enter:

java -jar target/demo-runner.jar

### Compiling to native

To compile the project to native code, you need to have the [GraalVM](https://github.com/oracle/graal/releases) installed
and a GRAALVM_HOME environment variable set to the location of the GraalVM home.

Once you have GraalVM install, build the native executable by running the following from the command line:

./mvnw package -Pnative

Once the compilation is finished, to run the executable, enter:

./target/demo-runner -Dinjected.value="hi" -Dvalue="hola"

## Testing the Endpoints
Use the tabs in the web app to access the URLs for the various services.
