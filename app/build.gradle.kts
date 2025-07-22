plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.serialization)

}

android {
    namespace = "com.easy_ride"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.easy_ride"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // for ConstraintLayout
    implementation (libs.androidx.constraintlayout.compose)

    //for splash
    implementation(libs.androidx.core.splashscreen)

    // ViewModel & LiveData (or StateFlow with lifecycle-viewmodel-ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Navigation Compose
    implementation(libs.androidx.navigation.compose) // Check for latest

    // Room
    implementation(libs.androidx.room.runtime) // Check for latest
    annotationProcessor(libs.androidx.room.compiler)
    //  kapt("androidx.room:room-compiler:2.7.2") // Use ksp instead of kapt
    implementation(libs.androidx.room.ktx) // For coroutines support

    // Coroutines
    implementation(libs.kotlinx.coroutines.core) // Check for latest
    implementation(libs.kotlinx.coroutines.android)

    // Google Maps
    implementation(libs.play.services.maps) // Check for latest
    implementation(libs.maps.compose) //


    implementation (libs.filament.android)
    implementation (libs.gltfio.android)


    // this support .ifc files(Industry Foundation Classes) and help to view on Android

    //implementation (libs.ifc.viewer)
}