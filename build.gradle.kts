buildscript {
    /** Various versions to be used throughout all modules. */
    extra.apply {
        // Android
        set("activity_version", "1.9.1")
        set("appcompat_version", "1.7.0")
        set("compose_version", "2024.08.00")
        set("compose_compiler_version", "1.5.15")
        set("core_version", "1.13.1")
        set("fragment_version", "1.8.2")
        set("lifecycle_version", "2.8.4")
        set("material_version", "1.12.0")
        set("navigation_version", "2.7.7")
        set("recyclerview_version", "1.3.2")
        set("room_version", "2.6.1")

        // Third-party
        set("dagger_version", "2.52")
        set("enhanced_adapter_version", "1.1.0")
        set("kotlin_version", "1.9.25")
        set("coroutines_version", "1.8.1")
        set("retrofit_version", "2.11.0")

        // Testing
        set("junit_version", "4.13.2")
        set("mockito_inline_version", "5.2.0")
        set("mockito_kotlin_version", "5.4.0")
        set("robolectric_version", "4.13")
        set("core_testing_version", "2.2.0")

        // SDKs
        set("compile_sdk", 34)
        set("min_sdk", 21)
        set("target_sdk", 34)
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlin_version"]}")

        // This dependency is for the Navigation library:
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${rootProject.extra["navigation_version"]}")
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
