plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = rootProject.extra["compile_sdk"] as Int
    defaultConfig {
        applicationId = "com.github.mrbean355.android"
        minSdk = rootProject.extra["min_sdk"] as Int
        targetSdk = rootProject.extra["target_sdk"] as Int
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        // To prevent a crash, we need to enable data binding in app modules which consume library modules that use data binding.
        dataBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }
}

dependencies {
    implementation(project(":framework"))
    implementation(project(":activity-contracts"))
    implementation(project(":coroutines"))
    implementation(project(":dagger-2"))
    implementation(project(":data-binding"))
    implementation(project(":enhanced-adapter"))
    implementation(project(":navigation"))
    implementation(project(":room"))
    implementation(project(":view-model"))
}
