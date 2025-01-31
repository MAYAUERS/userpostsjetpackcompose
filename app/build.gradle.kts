plugins {
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.userpostsjetpackcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.userpostsjetpackcompose"
        minSdk = 27
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
  /*  implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // Picasso dependency
    implementation ("com.squareup.picasso:picasso:2.71828")

    // LiveData & ViewModel
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.6.1")

  *//*  api ("io.insert-koin:koin-core:3.1.2")
    api ("io.insert-koin:koin-core-jvm:3.1.2")
    implementation ("io.insert-koin:koin-android:3.1.2")
    api ("io.insert-koin:koin-android-compat:3.1.2")
    testImplementation ("io.insert-koin:koin-test:3.1.2")*//*
    implementation ("io.insert-koin:koin-androidx-compose:3.1.2")
*/

    // OkHttp
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    //viewModel
 //   implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")


    //navigation
    implementation("androidx.hilt:hilt-navigation-fragment:1.2.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1-Beta")

}