// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0-alpha10" apply false
    id("com.android.library") version "8.2.0-alpha10" apply false
    id("org.jetbrains.kotlin.android") version "1.8.22" apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.11" apply false
}

buildscript {
    repositories {
        google()
        mavenLocal()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}