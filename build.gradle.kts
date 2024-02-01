// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("kapt") version "1.9.22"
    id("com.android.library") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.android.application") version "8.2.1" apply false
    id("com.android.dynamic-feature") version "8.2.1" apply false
}