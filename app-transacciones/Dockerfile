# docker build -t app-transacciones .
# docker run -d --name transacciones01 -p 8080:8080 app-transacciones

# docker tag app-transacciones nali1312/app-transacciones
# docker login
# docker build -t nali1312/app-transacciones .
# docker push nali1312/app-transacciones

#docker buildx build --platform linux/arm64 -t nali1312/app-transacciones:arm --push .

FROM eclipse-temurin:17-jdk

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/app ./app
COPY build/quarkus-app/lib ./lib
COPY build/quarkus-app/quarkus ./quarkus
COPY build/quarkus-app/quarkus-run.jar app.jar

CMD ["java", "-jar", "app.jar"]


