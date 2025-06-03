enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
<<<<<<< HEAD
        maven {
            url = uri("https://company/com/maven2")
        }
        mavenLocal()
        flatDir {
            dirs("libs")
        }
=======
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "tallerMultiplataforma1"
include(":androidApp")
include(":shared")