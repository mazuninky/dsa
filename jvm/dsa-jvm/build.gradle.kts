plugins {
    id("kotlin-platform-jvm")
    id("java-library")
}

dependencies {
    implementation(Config.JVM.kotlinStdlib)
    expectedBy(project(":dsa-common"))

    testImplementation(Config.JVM.junit)
    testImplementation(Config.JVM.kotlinTest)
    testImplementation(Config.JVM.kotlinTestJUnit)
}