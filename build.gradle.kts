buildscript {
    // подмена версии ниже нужна, потому что иначе возникает ошибка https://github.com/google/dagger/issues/3282
    // решение которой взято отсюда - https://github.com/google/dagger/issues/3068
    configurations.configureEach {
        resolutionStrategy.eachDependency {
            if (requested.name == "javapoet" ) {
                useVersion("1.13.0")
            }
        }
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.kapt) apply false
}