# docker build -t app-inventario .
# docker run -d --name inventario01 -p 8080:8080 app-inventario

# docker tag app-inventario nali1312/app-inventario
# docker login
# docker build -t nali1312/app-inventario .
# docker push nali1312/app-inventario

#docker buildx build --platform linux/arm64 -t nali1312/app-inventario:arm --push .

FROM eclipse-temurin:17-jdk

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/app ./app
COPY build/quarkus-app/lib ./lib
COPY build/quarkus-app/quarkus ./quarkus
COPY build/quarkus-app/quarkus-run.jar app.jar

CMD ["java", "-jar", "app.jar"]


