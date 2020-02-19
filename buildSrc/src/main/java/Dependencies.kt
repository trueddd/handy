object Dependencies {
    private const val appCompatVersion = "1.1.0"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val coreVersion = "1.1.0"
    const val coreCompat = "androidx.core:core:$coreVersion"

    private const val constraintLayoutVersion = "1.1.3"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

    private const val lifecycleVersion = "2.2.0"
    object Lifecycle {
        const val extensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Config.kotlinVersion}"

    private const val gradleToolsVersion = "3.5.3"
    const val gradleTools = "com.android.tools.build:gradle:$gradleToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Config.kotlinVersion}"

    private const val androidMavenGradlePluginVersion = "2.1"
    const val androidMavenGradlePlugin = "com.github.dcendents:android-maven-gradle-plugin:$androidMavenGradlePluginVersion"

    object Handy {
        const val core = "com.github.trueddd.handy:core:${Config.versionName}"
        const val databinding = "com.github.trueddd.handy:databinding:${Config.versionName}"
    }
}