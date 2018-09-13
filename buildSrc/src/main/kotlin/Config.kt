object Config {
    object Versions {
        const val kotlin = "1.3-M2"
        const val kotlinCoroutines = "0.25.3"
        const val androidGradle = "3.2.0-rc03"
        const val junit = "4.12"
        const val serialization = "0.6.1"
        const val native = "0.9"
    }

    object BuildPlugins {
        const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
        const val serializationGradlePlugin = "org.jetbrains.kotlinx:kotlinx-gradle-serialization-plugin:${Versions.serialization}"
        const val nativeGradlePlugin = "org.jetbrains.kotlin:kotlin-native-gradle-plugin:${Versions.native}"
    }

    object Android {
        const val buildToolsVersion = "28.0.2"
        const val minSdkVersion = 19
        const val targetSdkVersion = 28
        const val compileSdkVersion = 28
    }


    object Common {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
        const val kotlinCorutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.kotlinCoroutines}"
        const val kotlinTestAnnotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Versions.serialization}"
    }

    object JVM {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
        const val kotlinTestJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
        const val junit = "junit:junit:${Versions.junit}"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serialization}"
    }

    object JS {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-js:${Versions.kotlin}"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test-js:${Versions.kotlin}"
    }

    object Libs {
        val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    }
}
