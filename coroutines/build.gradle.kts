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
}

dependencies {
    val coroutines_version: String by rootProject.extra
    val core_testing_version: String by rootProject.extra
    val junit_version: String by rootProject.extra
    val mockito_inline_version: String by rootProject.extra
    val mockito_kotlin_version: String by rootProject.extra
    val robolectric_version: String by rootProject.extra

    // Main dependency:
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

    // Test helpers:
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version")
    testImplementation("androidx.arch.core:core-testing:$core_testing_version")

    // Test frameworks:
    testImplementation("junit:junit:$junit_version")
    testImplementation("org.mockito:mockito-inline:$mockito_inline_version")
    testImplementation("org.mockito.kotlin:mockito-kotlin:$mockito_kotlin_version")
    testImplementation("org.robolectric:robolectric:$robolectric_version")

    // Other dependencies (not relevant):
    implementation(project(":framework"))
}