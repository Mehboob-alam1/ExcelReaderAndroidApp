plugins {
    id("com.android.application")
}

android {
    namespace = "com.mehboob.excelreaderandroidapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mehboob.excelreaderandroidapp"
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

    buildFeatures{
        viewBinding=true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {


    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation ("com.google.code.gson:gson:2.10.1")


    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-paging:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

}