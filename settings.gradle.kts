rootProject.name = "PlaceBooker"
include(":composeApp")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/static-releases")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
