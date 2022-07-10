plugins {
    kotlin("jvm") version "1.7.10"
    application
}

application {
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.+")
}
