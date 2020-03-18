# Quarkus Tracing Example

Example application for blog post https://medium.com/jaegertracing/microprofile-tracing-in-supersonic-subatomic-quarkus-43020f89a753

## Run
Start Jaeger server so we can receive some traces from Quarkus:
```bash
docker run --rm -it --name jaeger \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14268:14268 \
  jaegertracing/all-in-one:1.14
```

Development mode
```bash
./mvnw compile quarkus:dev
```

Compile as a normal Java application:
```bash
./mvnw clean package
java -jar target/tracing-example-1.0-SNAPSHOT-runner.jar
```

Compile to native code requires installation of GraalVM.
Refer to the Quarkus or GraalVM documentation how to install it.
```bash
./mvnw package -Pnative
./target/tracing-example-1.0-SNAPSHOT-runner
```

Execute request:
```bash
curl -ivX GET localhost:8080/hello
curl -ivX GET localhost:8080/conversation
```

Navigate to http://localhost:16686/ to access the Jaeger UI.

Other links
```bash
curl http://localhost:8080/hello
curl http://localhost:8080/bonjour
curl -H "Accept: application/json" http://localhost:8080/metrics/application
curl http://localhost:8080/health/live
curl http://localhost:8080/health/ready
```

