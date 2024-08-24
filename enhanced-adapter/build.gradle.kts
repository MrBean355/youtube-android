plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.github.mrbean355.android.yt.enhancedadapter"
    compileSdk = rootProject.extra["compile_sdk"] as Int
    defaultConfig {
        minSdk = rootProject.extra["min_sdk"] as Int
        targetSdk = rootProject.extra["target_sdk"] as Int
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    val enhanced_adapter_version: String by rootProject.extra

    // Main dependency:
    implementation("com.github.mrbean355:enhanced-adapter:$enhanced_adapter_version")

    // Other dependencies (not relevant):
    implementation(project(":framework"))
}
