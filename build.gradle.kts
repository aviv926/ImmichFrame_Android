// android {
    // ... other configurations

    // You can remove or comment out the entire signingConfigs block
    // if it's only used for CI signing and you'll sign locally.
    /*
    signingConfigs {
        create("release") {
            // Details for signing, which we will skip in CI
        }
    }
    */

//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            // Ensure this line is removed or commented out if you don't want CI to sign:
            // signingConfig = signingConfigs.getByName("release")
//        }
//    }
// ...
// }
