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
    val activity_version: String by rootProject.extra
    val appcompat_version: String by rootProject.extra
    val core_version: String by rootProject.extra
    val fragment_version: String by rootProject.extra
    val lifecycle_version: String by rootProject.extra
    val recyclerview_version: String by rootProject.extra
    val material_version: String by rootProject.extra
    val retrofit_version: String by rootProject.extra
    val compose_version: String by rootProject.extra

    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
    api("androidx.activity:activity-ktx:$activity_version")
    api("androidx.appcompat:appcompat:$appcompat_version")
    api("androidx.core:core-ktx:$core_version")
    api("androidx.fragment:fragment-ktx:$fragment_version")
    api("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
    api("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    api("androidx.recyclerview:recyclerview:$recyclerview_version")
    api("com.google.android.material:material:$material_version")
    api("com.squareup.retrofit2:retrofit:$retrofit_version")
    api("com.squareup.retrofit2:converter-gson:$retrofit_version")

    api(platform("androidx.compose:compose-bom:$compose_version"))
    api("androidx.compose.ui:ui")
    api("androidx.compose.ui:ui-tooling")
    api("androidx.compose.foundation:foundation")
    api("androidx.compose.material:material")
    api("androidx.compose.material:material-icons-core")
    api("androidx.compose.material:material-icons-extended")
    api("androidx.activity:activity-compose:$activity_version")
}
