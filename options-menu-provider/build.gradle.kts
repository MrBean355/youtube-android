plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = rootProject.extra["compile_sdk"] as Int
    defaultConfig {
        minSdk = rootProject.extra["min_sdk"] as Int
        targetSdk = rootProject.extra["target_sdk"] as Int
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_compiler_version"] as String
    }
}

dependencies {
    val activity_version: String by rootProject.extra
    val fragment_version: String by rootProject.extra

    // Main dependencies:
    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // Other dependencies (not relevant):
    implementation(project(":framework"))
}