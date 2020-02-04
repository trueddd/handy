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
    buildToolsVersion = Config.buildTools
    compileSdkVersion(Config.VersionsSDK.compile)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    defaultConfig {
        minSdkVersion(Config.VersionsSDK.min)
        targetSdkVersion(Config.VersionsSDK.target)
        versionCode = Config.versionCode
        versionName = Config.versionName
    }
    lintOptions {
        isCheckReleaseBuilds = false
        isAbortOnError  = false
        setDisable(setOf("GradleCompatible", "FontValidationError"))
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlinStdLib)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.coreCompat)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.Lifecycle.extensions)
    implementation(Dependencies.Lifecycle.viewModel)
}