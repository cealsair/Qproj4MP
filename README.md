# Qproj4MP

## Quarking a generated MicroProfile projec

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

### ServiceHealthCheck
curl http://10.0.0.225:8080/health; echo

### ConfigTestController
curl http://10.0.0.225:8080/data/config/injected; echo
curl http://10.0.0.225:8080/data/config/lookup; echo

### HelloController
curl http://10.0.0.225:8080/data/hello; echo

### ProtectedController

### MetricController
curl http://10.0.0.225:8080/metrics; echo
