import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqlDelight)
<<<<<<< HEAD
    alias(libs.plugins.ktor)



=======
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.sqlite.driver)
<<<<<<< HEAD
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.coroutines.core)
=======
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
            //put your multiplatform dependencies here
        }
        androidMain.dependencies {
            implementation(libs.android.driver)
<<<<<<< HEAD
            implementation(libs.ktor.client.android)
            implementation(libs.ktor.client.okhttp)
        }
        iosMain.dependencies {
            implementation(libs.native.driver)
            implementation(libs.ktor.client.darwin)
=======
        }
        iosMain.dependencies {
            implementation(libs.native.driver)
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

    }
}


android {
    namespace = "com.example.tallermultiplataforma1"
    compileSdk = 35
    defaultConfig {
        minSdk = 29
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
<<<<<<< HEAD
dependencies {
    implementation(libs.androidx.compose.material.core)
}
=======
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("com.example.marvelsql")
        }
    }
}