import org.jetbrains.kotlin.gradle.plugin.extraProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-android")
    id("com.google.devtools.ksp")
    id("kotlin-kapt")

}

android {
    namespace = "com.mushudevelopment.dailyplanner"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mushudevelopment.dailyplanner"
        minSdk = 24
        targetSdk = 33
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
        freeCompilerArgs += listOf(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
        )
    }
    kotlin {
        sourceSets.main {
            kotlin.srcDir("build/generated/ksp/main/kotlin")
        }
        sourceSets.test {
            kotlin.srcDir("build/generated/ksp/test/kotlin")
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("com.google.truth:truth:1.1.5")
    androidTestImplementation("android.arch.core:core-testing:1.1.1")

    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.11")

    /*Coroutines*/
    val coroutineVersion = "1.7.2"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")

    /*Compose*/
    val composeBom = platform("androidx.compose:compose-bom:2023.06.01")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.4.3")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.3")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.2")

    /*Hilt Dependency Injection*/
    val hiltVersion = "2.46.1"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    ksp("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    /*Material Design 3*/
    val lifecycleComponentsVersion = "2.6.1"
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleComponentsVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycleComponentsVersion")

    /*Database*/
    val roomVersion = "2.5.2"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    // To use Kotlin Symbol Processing (KSP)
    ksp("androidx.room:room-compiler:$roomVersion")
    // optional - Test helpers
    implementation("androidx.room:room-testing:$roomVersion")
    //Used for flow testing
    androidTestImplementation("app.cash.turbine:turbine:1.0.0")

    /*Coil compose*/
    implementation("io.coil-kt:coil-compose:2.4.0")

    /*Paging*/
    implementation("androidx.paging:paging-runtime-ktx:3.2.0-rc01")
    implementation("androidx.paging:paging-compose:3.2.0-rc01")

    /*Retrofit*/
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")
}