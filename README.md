Handy Android utils test library

[![](https://jitpack.io/v/trueddd/handy.svg)](https://jitpack.io/#trueddd/handy)

Kotlin Gradle DSL implementation:

Core utils:
```kotlin
implementation("com.github.trueddd.handy:core:$libVersion")
```

DataBinding utils:
```kotlin
implementation("com.github.trueddd.handy:databinding:$libVersion")
```

Add maven repository to your project root build.gradle file:
```kotlin
allprojects {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
}
```
