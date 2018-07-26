import org.jetbrains.kotlin.gradle.dsl.Coroutines

/*
import org.gradle.api.plugins.ExtensionAware

import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

buildscript {
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0")
    }
}

apply {
    plugin("org.junit.platform.gradle.plugin")
}

configure<JUnitPlatformExtension> {
    filters {
        engines {
            include("spek")
        }
    }
}
 */

plugins {
    kotlin("jvm")
}

kotlin {
    experimental.coroutines = Coroutines.ENABLE
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(Config.Libs.kotlinCoroutines)

    testImplementation(Config.TestLibs.jUnit)
    testImplementation(Config.TestLibs.kotlinTestJUnit)

    /*testImplementation(Config.TestLibs.kotlinTest)
     testImplementation("org.jetbrains.kotlin:kotlin-reflect:${Config.Versions.kotlin}")
     testImplementation("org.jetbrains.spek:spek-api:1.1.5") {
         exclude(group = "org.jetbrains.kotlin")
     }
     testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.5") {
         exclude(group = "org.junit.platform")
         exclude(group = "org.jetbrains.kotlin")
     }*/
}

/*
fun JUnitPlatformExtension.filters(setup: FiltersExtension.() -> Unit) {
    when (this) {
        is ExtensionAware -> extensions.getByType(FiltersExtension::class.java).setup()
        else -> throw Exception("${this::class} must be an instance of ExtensionAware")
    }
}

fun FiltersExtension.engines(setup: EnginesExtension.() -> Unit) {
    when (this) {
        is ExtensionAware -> extensions.getByType(EnginesExtension::class.java).setup()
        else -> throw Exception("${this::class} must be an instance of ExtensionAware")
    }
}
 */