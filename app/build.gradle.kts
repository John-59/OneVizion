plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.john.projects.onevizion"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.john.projects.onevizion"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(project(":core:backend"))
    implementation(project(":services:backend"))

    implementation(project(":core:repository"))
    implementation(project(":services:repository"))

    implementation(project(":core:ui"))
    implementation(project(":core:navigation"))
    implementation(project(":features:items"))
    implementation(project(":features:details"))

    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.dagger.hilt.android)

    kapt(libs.dagger.hilt.android.compliler)
}