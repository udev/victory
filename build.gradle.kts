import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    maven
    kotlin("jvm") version "1.2.51"
}

group = "com.udev"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile("org.junit.jupiter", "junit-jupiter-api", "5.3.2")
    testCompile("org.junit.jupiter", "junit-jupiter-engine", "5.3.2")
    testCompile("org.junit.jupiter", "junit-jupiter-params", "5.3.2")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}