plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.daffa.minimisi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.daffa.minimisi"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val koin_version = "3.4.3"
    val koin_android_version = "3.4.3"
    val koin_android_compose_version = "3.4.3"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Compose dependencies
    implementation("androidx.wear.compose:compose-navigation:1.2.0")
    implementation("androidx.compose.material:material-icons-core:1.5.1")
    implementation("androidx.compose.material:material-icons-extended:1.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.navigation:navigation-compose:2.7.2")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha12")
    implementation("com.google.accompanist:accompanist-flowlayout:0.31.1-alpha")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")

    // Coil
    implementation ("io.coil-kt:coil:2.2.2")
    implementation ("com.google.accompanist:accompanist-coil:0.10.0")
    implementation ("io.coil-kt:coil-compose:2.2.2")

    //koin
    implementation ("io.insert-koin:koin-core:$koin_version")
    implementation ("io.insert-koin:koin-android:$koin_android_version")
    implementation( "io.insert-koin:koin-androidx-workmanager:$koin_android_version")
    implementation ("io.insert-koin:koin-androidx-navigation:$koin_android_version")
    implementation ("io.insert-koin:koin-androidx-compose:$koin_android_compose_version")

    // Palette
    implementation ("androidx.palette:palette-ktx:1.0.0")

    // UI Controller
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.27.0")

    // Splash API
    implementation ("androidx.core:core-splashscreen:1.0.1")

    // Foundation
    implementation ("androidx.compose.foundation:foundation:1.5.1")

    // Pager
    implementation ("com.google.accompanist:accompanist-pager:0.12.0")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.12.0")

    // DataStore Preferences
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // Firebase
    implementation ("com.google.firebase:firebase-analytics-ktx:21.3.0")
    implementation ("com.google.firebase:firebase-auth-ktx:22.1.1")

    // Room
    implementation("androidx.room:room-ktx:2.5.2")
    implementation("androidx.room:room-runtime:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")
    androidTestImplementation("androidx.room:room-testing:2.5.2")

    // Local Unit Tests
    implementation ("androidx.test:core:1.5.0")
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.hamcrest:hamcrest-all:1.3")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.robolectric:robolectric:4.9")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    testImplementation ("com.google.truth:truth:1.1.3")
    testImplementation ("com.squareup.okhttp3:mockwebserver:4.9.1")
    testImplementation ("io.mockk:mockk:1.10.5")
    testImplementation ("org.robolectric:robolectric:4.9")

    // Instrumented Unit Tests
    androidTestImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ("com.google.truth:truth:1.1.3")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test:core-ktx:1.5.0")
    androidTestImplementation ("com.squareup.okhttp3:mockwebserver:4.9.1")
    androidTestImplementation ("io.mockk:mockk-android:1.10.5")
}