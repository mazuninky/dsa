import org.jetbrains.kotlin.gradle.dsl.Coroutines

plugins {
    base
    kotlin("jvm") version Config.Versions.kotlin apply false
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = Config.Versions.kotlin))
    }
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        jcenter()
    }
}
