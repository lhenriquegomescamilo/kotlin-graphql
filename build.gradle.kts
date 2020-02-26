plugins {
    kotlin("jvm") version "1.3.61"
}

group = "com.camilo"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.spring.io/milestone")
    maven("https://repo.spring.io/snapshot")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.expediagroup:graphql-kotlin-spring-server:2.0.0-RC6")


}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
