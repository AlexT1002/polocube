plugins {
    kotlin("jvm") version "2.2.0"
}

tasks.test {
    useJUnitPlatform()
}

allprojects {
    apply(plugin = "kotlin")

    group = "dev.httpmarco.polocube"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        maven {
            name = "papermc"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
    }

    kotlin {
        jvmToolchain(23)
    }
}