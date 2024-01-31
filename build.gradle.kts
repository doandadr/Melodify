// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
}

plugins {
    kotlin("kapt") version "1.9.22"
    id("com.android.library") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.android.application") version "8.2.1" apply false
    id ("com.google.dagger.hilt.android") version "2.50" apply false
    id("com.android.dynamic-feature") version "8.2.1" apply false
}