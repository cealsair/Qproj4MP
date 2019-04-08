# Qproj4MP

After cloning this project to your Mac, build it by changing directory to it and then running this command to exexute the application in development mode:

./mvnw compile quarkus:dev

Once application is up and running, point your browser to:

http://localhost:8080/index.html

To generate the standalone executable JAR file, run the following from the command line:

./mvn clean package

Once the build is finished, to run the jar, enter:

java -jar target/demo-1.0-SNAPSHOT-runner.jar
