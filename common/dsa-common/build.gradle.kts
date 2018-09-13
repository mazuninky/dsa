plugins {
    id("kotlin-platform-common")
}

dependencies {
    implementation(Config.Common.kotlinStdlib)
    //implementation(Config.Common.serialization)
    implementation(Config.Common.kotlinCorutines)
    testImplementation(Config.Common.kotlinTest)
    testImplementation(Config.Common.kotlinTestAnnotations)
}
