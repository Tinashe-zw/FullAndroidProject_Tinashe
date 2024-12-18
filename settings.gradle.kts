pluginManagement {
    repositories {
        google() // Required for Android Gradle Plugin
        mavenCentral() // Required for other dependencies
        gradlePluginPortal() // Required for Kotlin plugins
    }
}
dependencyResolutionManagement {
    repositories {
        google() // Required for Android Gradle Plugin
        mavenCentral() // Required for other dependencies
    }
}
rootProject.name = "FullAndroidProject"
include(":app")
