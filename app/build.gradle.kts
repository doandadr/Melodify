plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}
apply(from = "../shared_dependencies.gradle")

android {
    namespace = "com.doanda.melodify"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.doanda.melodify"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    dynamicFeatures += setOf(":favorite")
}

dependencies {
    implementation(project(":core"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.22")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    // VIEWPAGER
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // NAVIGATION
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
}