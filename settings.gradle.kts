rootProject.name = "dsa"


fun module(path: String) {
    val i = path.lastIndexOf('/')
    val name = path.substring(i + 1)
    include(name)
    project(":$name").projectDir = File(path)
}

module("common/dsa-common")
module("jvm/dsa-jvm")
//module("native/dsa-native")