buildscript {
    /** Various versions to be used throughout all modules. */
    extra.apply {
        // Android
        set("activity_version", "1.4.0")
        set("appcompat_version", "1.4.2")
        set("compose_version", "1.1.1")
        set("core_version", "1.8.0")
        set("fragment_version", "1.4.1")
        set("lifecycle_version", "2.4.1")
        set("material_version", "1.6.1")
        set("navigation_version", "2.4.2")
        set("recyclerview_version", "1.2.1")
        set("room_version", "2.4.2")

        // Third-party
        set("dagger_version", "2.42")
        set("enhanced_adapter_version", "1.1.0")
        set("kotlin_version", "1.6.10")
        set("coroutines_version", "1.6.2")
        set("retrofit_version", "2.9.0")

        // Testing
        set("junit_version", "4.13.2")
        set("mockito_inline_version", "4.6.1")
        set("mockito_kotlin_version", "4.0.0")
        set("robolectric_version", "4.8.1")
        set("core_testing_version", "2.1.0")

        // SDKs
        set("compile_sdk", 31)
        set("min_sdk", 21)
        set("target_sdk", 31)
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlin_version"]}")

        /* BEGIN: section for Navigation component */

        // AndroidX:
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${rootProject.extra["navigation_version"]}")
        // Pre-AndroidX:
        // classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:$latest_version")

        /* END: section for Navigation component */
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
