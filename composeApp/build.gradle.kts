plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget()
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                // Твои инструменты из плана
                implementation("cafe.adriel.voyager:voyager-navigator:1.1.0-beta02")
                implementation("io.insert-koin:koin-core:3.5.6")
            }
        }
    }
}

android {
    namespace = "org.example.placebooker"
    compileSdk = 34
    defaultConfig {
        applicationId = "org.example.placebooker"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
}
