plugins {
    id("com.android.library")
    kotlin("android")

    // With Kotlin:
    id("androidx.navigation.safeargs.kotlin")
    // Without Kotlin:
    // id("androidx.navigation.safeargs")
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
}

dependencies {
    val navigation_version: String by rootProject.extra

    // AndroidX with Kotlin:
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation_version")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation_version")

    // AndroidX without Kotlin:
    // implementation("androidx.navigation:navigation-fragment:$navigation_version")
    // implementation("androidx.navigation:navigation-ui:$navigation_version")

    // Pre-AndroidX with Kotlin:
    // implementation("android.arch.navigation:navigation-fragment-ktx:$latest_version")
    // implementation("android.arch.navigation:navigation-ui-ktx:$latest_version")

    // Pre-AndroidX without Kotlin:
    // implementation("android.arch.navigation:navigation-fragment:$latest_version")
    // implementation("android.arch.navigation:navigation-ui:$latest_version")

    // Other dependencies (not relevant):
    implementation(project(":framework"))
}
