plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.ariebisfki"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val mockkVersion = "1.13.9"
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:${mockkVersion}")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}
