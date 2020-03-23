object Config {
    const val appID = "com.github.trueddd.handy"
    const val versionCode = 11
    const val versionName = "0.1.1"

    const val buildTools = "29.0.1"
    object VersionsSDK {
        const val compile = 29
        const val target = 29
        const val min = 21
    }

    const val kotlinVersion = "1.3.61"

    object Modules {
        const val Root = "com.github.trueddd.handy"
        const val Core = "$Root:core"
        const val DataBinding = "$Root:databinding"
    }
}