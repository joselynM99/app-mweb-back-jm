plugins {
    id("java")
    id("io.quarkus") version "3.6.5"
    id("io.freefair.lombok") version "8.4"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val quarkusVersion = "3.6.5"

dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:${quarkusVersion}"))

    implementation("io.quarkus:quarkus-arc") //CDI: Arc
    implementation("io.quarkus:quarkus-resteasy-reactive") //JAX-RS: RESTEasy
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson") //JAX-RS-Json: Jackson
    implementation("io.quarkus:quarkus-hibernate-orm-panache") //JPA: Hibernate
    implementation("io.quarkus:quarkus-jdbc-postgresql") //Driver JDBC: PostgreSQL
    implementation("io.quarkus:quarkus-smallrye-jwt") // MicroProfile JWT
    implementation("io.smallrye:smallrye-jwt-build") // SmallRye JWT Build

    // REST client reactive
    implementation("io.quarkus:quarkus-rest-client-reactive")
    implementation("io.quarkus:quarkus-rest-client-reactive-jackson")

    // OIDC and Keycloak
    implementation("io.quarkus:quarkus-oidc")
    implementation("io.quarkus:quarkus-oidc-client")
    implementation("io.quarkus:quarkus-keycloak-authorization")

    // Keycloak Admin Client
//    implementation("org.keycloak:keycloak-admin-client") // Reemplaza 21.0.1 con la última versión compatible
}

tasks.test {
    useJUnitPlatform()
}