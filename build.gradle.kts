plugins {
    base
}

allprojects {
    repositories {
        jcenter()
        google()
        mavenCentral()
        mavenLocal()
        maven(url = "https://kotlin.bintray.com/kotlinx")
        maven(url = "http://dl.bintray.com/kotlin/kotlin-eap")
    }
}

buildscript {
    repositories {
        jcenter()
        google()
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
        maven(url = "https://kotlin.bintray.com/kotlinx")
        maven(url = "http://dl.bintray.com/kotlin/kotlin-eap")
    }
    dependencies {
        //classpath(Config.BuildPlugins.androidGradle)
        //classpath(Config.BuildPlugins.serializationGradlePlugin)
        classpath(kotlin("gradle-plugin", version = Config.Versions.kotlin))
       // classpath(Config.BuildPlugins.nativeGradlePlugin)
    }
}
