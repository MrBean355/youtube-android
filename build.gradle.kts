buildscript {
    /** Various versions to be used throughout all modules. */
    extra.apply {
        // Android
        set("activity_version", "1.6.1")
        set("appcompat_version", "1.5.1")
        set("compose_version", "2022.12.00")
        set("compose_compiler_version", "1.3.2")
        set("core_version", "1.9.0")
        set("fragment_version", "1.5.5")
        set("lifecycle_version", "2.5.1")
        set("material_version", "1.7.0")
        set("navigation_version", "2.5.3")
        set("recyclerview_version", "1.2.1")
        set("room_version", "2.4.3")

        // Third-party
        set("dagger_version", "2.44.2")
        set("enhanced_adapter_version", "1.1.0")
        set("kotlin_version", "1.7.20")
        set("coroutines_version", "1.6.4")
        set("retrofit_version", "2.9.0")

        // Testing
        set("junit_version", "4.13.2")
        set("mockito_inline_version", "4.11.0")
        set("mockito_kotlin_version", "4.1.0")
        set("robolectric_version", "4.9.2")
        set("core_testing_version", "2.1.0")

        // SDKs
        set("compile_sdk", 33)
        set("min_sdk", 21)
        set("target_sdk", 33)
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
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
