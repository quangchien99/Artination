plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.anvil)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.unsplash.artination"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.unsplash.artination"
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
    ksp(libs.circuit.codegen)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    api(libs.kotlinx.serialization.core)

    //Datastore
    implementation(libs.androidx.datastore.core)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore.preferences.core)

    //Anvil
    implementation(libs.anvil.annotations)
    implementation(libs.anvil.annotationsOptional)

    //Circuit
    implementation(libs.circuit.backstack)
    implementation(libs.circuit.codegenAnnotations)
    implementation(libs.circuit.foundation)
    implementation(libs.circuit.overlay)
    implementation(libs.circuit.retained)
    implementation(libs.circuit.runtime)
    implementation(libs.circuit.runtime.presenter)
    implementation(libs.circuit.runtime.screen)
    implementation(libs.circuit.runtime.ui)
    implementation(libs.circuitx.android)
    implementation(libs.circuitx.gestureNav)
    implementation(libs.circuitx.overlays)

    //Coil
    implementation(libs.coil.base)
    implementation(libs.coil.compose)
    implementation(libs.coil.compose.base)
    implementation(libs.coil.default)
    implementation(libs.coil.gif)

    //okhttp
    implementation(libs.okhttp.core)
    debugImplementation(libs.okhttp.debug.loggingInterceptor)
}