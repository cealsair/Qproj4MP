# Qproj4MP

## Quarking a generated MicroProfile project

Note: The contents of the src directory of this project came from generating an MP 2.1 project for Thorntail V2 using the [MicroProfile Starter](https://start.microprofile.io). Once you unzip the generated source code by MicroProfile Starter, make sure to copy index.html from the generated source code to the directory src/main/resources/META-INF/resources in your destination directory where you will be quarking the project.

First, clone this project to your Mac, build it by changing directory to it and then running this command to exexute the application in development mode:

./mvnw compile quarkus:dev

Once application is up and running, point your browser to:

http://localhost:8080/index.html

### Generating an executable JAR

To generate the standalone executable JAR file, run the following from the command line:

./mvn clean package

Once the build is finished, to run the jar, enter:

java -jar target/demo-1.0-SNAPSHOT-runner.jar

### Compiling to native

To compile the project to native code, run the following from the command line:

./mvnw package -Pnative

Once the compilation is finished, to run the executable, enter:

./target/demo-1.0-SNAPSHOT-runner -Dinjected.value="hi" -Dvalue="hola"

Note: If you'd like to have the configurable variables, injected.value and value defined in a file, make sure to copy the contents of the microprofile-config.properties file from the generated source code by MicroProfile Starter to the file src/main/resources/application.properties in your destination directory where you will be quarking the project.
