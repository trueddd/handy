import java.net.URI

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("com.github.dcendents.android-maven")
}

repositories {
    mavenCentral()
    google()
    jcenter()
    maven { url = URI("https://jitpack.io") }
}

group = "com.github.trueddd"
version = "0.0.1"

kapt {
    correctErrorTypes = true
}

androidExtensions {
    isExperimental = true
}

android {
    buildToolsVersion = "29.0.1"
    compileSdkVersion(29)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    lintOptions {
        isCheckReleaseBuilds = false
        isAbortOnError  = false
        setDisable(setOf("GradleCompatible", "FontValidationError"))
    }
}

dependencies {
    val kotlinVersion = "1.3.61"
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
}