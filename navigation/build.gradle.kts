plugins {
    id("com.android.library")
    kotlin("android")

    // Projects WITH Kotlin support:
    id("androidx.navigation.safeargs.kotlin")
    // Projects WITHOUT Kotlin support:
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

    // Main dependencies:

    // Projects WITH Kotlin support:
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation_version")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation_version")

    // Projects WITHOUT Kotlin support:
    // implementation("androidx.navigation:navigation-fragment:$navigation_version")
    // implementation("androidx.navigation:navigation-ui:$navigation_version")

    // Other dependencies (not relevant):
    implementation(project(":framework"))
}
