// This file is typically located at project_root/app/build.gradle.kts

// ... other plugins and configurations at the top

android {
    // ... namespace, compileSdk, defaultConfig, etc. ...

    // If you have a signingConfigs block like this, it's fine for it to exist,
    // but it should NOT be applied to the release build type below if you want an unsigned APK.
    /*
    signingConfigs {
        create("release") {
            // This is where you might have had keystore loading logic.
            // For an unsigned CI build, this whole config shouldn't be applied
            // to the release build type.
            // Example:
            // val storeFilePath = System.getenv("RELEASE_STORE_FILE_PATH")
            // if (storeFilePath != null) {
            //     storeFile = file(storeFilePath)
            //     storePassword = System.getenv("RELEASE_KEYSTORE_PASSWORD")
            //     keyAlias = System.getenv("RELEASE_KEY_ALIAS")
            //     keyPassword = System.getenv("RELEASE_KEY_PASSWORD")
            // }
        }
    }
    */

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false // Or true, depending on your project
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            // CRITICAL STEP: Ensure this line is REMOVED or COMMENTED OUT:
            // signingConfig = signingConfigs.getByName("release")
            // OR
            // signingConfig = signingConfigs.named("release").get() // another way it might be written

            // By removing the line above, Gradle should not attempt to apply
            // a specific signing configuration that requires a storeFile
            // for the release build in CI. It should then produce an unsigned APK.
        }
        // ... other build types like debug
    }

    // ... other android configurations ...
}

// ... dependencies, etc. ...
