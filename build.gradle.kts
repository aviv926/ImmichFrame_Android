android {
    // ... other configurations (compileSdk, defaultConfig, etc.)

    signingConfigs {
        release {
            if (System.getenv("RELEASE_STORE_FILE_PATH") != null) {
                storeFile file(System.getenv("RELEASE_STORE_FILE_PATH"))
                storePassword System.getenv("RELEASE_KEYSTORE_PASSWORD")
                keyAlias System.getenv("RELEASE_KEY_ALIAS")
                keyPassword System.getenv("RELEASE_KEY_PASSWORD")
            } else {
                // Optional: Configuration for local builds, e.g., using a local keystore.properties
                // Make sure keystore.properties is in .gitignore
                // storeFile file("../keystore.properties")
                // storePassword ...
                // keyAlias ...
                // keyPassword ...
                println("Warning: Release signing information not found in environment variables.")
            }
        }
    }

    buildTypes {
        release {
            signingConfig signingConfigs.release
            // ... other release build type configurations (e.g., minifyEnabled, proguardFiles)
        }
    }
    // ...
}
