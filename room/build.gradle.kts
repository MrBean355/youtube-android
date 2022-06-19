plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = rootProject.extra["compile_sdk"] as Int
    defaultConfig {
        minSdk = rootProject.extra["min_sdk"] as Int
        targetSdk = rootProject.extra["target_sdk"] as Int
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
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
    val room_version: String by rootProject.extra

    implementation("androidx.room:room-runtime:$room_version")
    // For Java use 'annotationProcessor' instead of 'kapt':
    kapt("androidx.room:room-compiler:$room_version")

    // optional - Kotlin Extensions and Coroutines support for Room:
    // implementation("androidx.room:room-ktx:$room_version")

    // optional - RxJava support for Room:
    // implementation("androidx.room:room-rxjava2:$room_version")

    // optional - Guava support for Room, including Optional and ListenableFuture:
    // implementation("androidx.room:room-guava:$room_version")

    // Test helpers:
    // testImplementation("androidx.room:room-testing:$room_version")

    // Other dependencies (not relevant):
    implementation(project(":framework"))
}
