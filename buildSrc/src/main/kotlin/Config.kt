object Config {
    object Versions {
        const val kotlin = "1.2.51"
        const val kotlinCoroutines = "0.23.4"
        const val junit = "4.12"
    }

    object Libs {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"

    }

    object TestLibs {
        const val jUnit = "junit:junit:${Versions.junit}"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
        const val kotlinTestJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    }
}
