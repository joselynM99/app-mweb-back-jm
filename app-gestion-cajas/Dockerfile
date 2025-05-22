# docker build -t app-gestion-cajas .
#docker buildx build --platform linux/arm64 -t nali1312/app-gestion-cajas:arm --push .
# docker tag app-gestion-cajas nali1312/app-gestion-cajas
# docker login
# docker build -t nali1312/app-gestion-cajas .
# docker push nali1312/app-gestion-cajas

FROM eclipse-temurin:17-jdk

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/app ./app
COPY build/quarkus-app/lib ./lib
COPY build/quarkus-app/quarkus ./quarkus
COPY build/quarkus-app/quarkus-run.jar app.jar

CMD ["java", "-jar", "app.jar"]

