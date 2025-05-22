# docker build -t app-negocios .
# docker run -d --name negocios01 -p 8080:8080 app-negocios

# docker tag app-negocios nali1312/app-negocios
# docker login
# docker build -t nali1312/app-negocios .
# docker push nali1312/app-negocios

# docker buildx build --platform linux/arm64 -t nali1312/app-negocios:arm --push .

FROM eclipse-temurin:17-jdk

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/app ./app
COPY build/quarkus-app/lib ./lib
COPY build/quarkus-app/quarkus ./quarkus
COPY build/quarkus-app/quarkus-run.jar app.jar

CMD ["java", "-jar", "app.jar"]


