plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.github.mrbean355.android.viewmodel"
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
    val lifecycle_version: String by rootProject.extra
    val fragment_version: String by rootProject.extra

    // Main dependencies:
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    // Optional, if you use Kotlin:
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // Other dependencies (not relevant):
    implementation(project(":framework"))
}
