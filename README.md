# Android Boilerplate (Kotlin)

Sample Android app demonstrates the architecture, tools and guidelines that we use when developing for the Android platform

Libraries and tools included:

- Support libraries
- RecyclerViews and CardViews 
- [RxJava](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid) 
- [Retrofit 2](http://square.github.io/retrofit/)
- [Dagger 2](http://google.github.io/dagger/)
- [Butterknife](https://github.com/JakeWharton/butterknife)
- [Timber](https://github.com/JakeWharton/timber)
- [Glide](https://github.com/bumptech/glide)
- [Robolectric](http://robolectric.org/)
- [Mockito](http://mockito.org/)
- fragmentNavigation (Module project to manage fragments navigation)
- Databinding
- [SDP](https://github.com/intuit/sdp)

## Requirements

- JDK 1.8
- [Android SDK](http://developer.android.com/sdk/index.html).
- Android N [(API 24) ](http://developer.android.com/tools/revisions/platforms.html).
- Latest Android SDK Tools and build tools.


## Architecture

This project is based on [MVP (Model View Presenter)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter).

### How to implement a new screen following MVP

Imagine you have to implement a sign in screen. 

1. Create a new package under `ui` called `signin`
2. Create an new Activity called `SigninActivity`. You could also use a Fragment.
3. Define the view interface that your Activity is going to implement. Create a new interface called `SignInMvpView` that extends `MvpView`. Add the methods that you think will be necessary, e.g. `showSignInSuccessful()`
4. Create a `SignInPresenter` class that extends `BasePresenter<SignInMvpView>`
5. Implement the methods in `SignInPresenter` that your Activity requires to perform the necessary actions, e.g. `signIn(String email)`. Once the sign in action finishes you should call `getMvpView().showSignInSuccessful()`.
6. Create a `SignInPresenterTest`and write unit tests for `signIn(email)`. Remember to mock the  `SignInMvpView` and also the `DataManager`.
7. Make your  `ActivitySignIn` implement `SignInMvpView` and implement the required methods like `showSignInSuccessful()`
8. In your activity, inject a new instance of `SignInPresenter` and call `presenter.attachView(this)` from `onCreate` and `presenter.detachView()` from `onDestroy()`. Also, set up a click listener in your button that calls `presenter.signIn(email)`.

## Code Quality

This project integrates a combination of unit tests, functional test and code analysis tools. 

### Tests

To run **unit** tests on your machine:

``` 
./gradlew test
``` 

To run **functional** tests on connected devices:

``` 
./gradlew connectedAndroidTest (in progress)
``` 

Note: For Android Studio to use syntax highlighting for Automated tests and Unit tests you **must** switch the Build Variant to the desired mode.


 
## Distribution

The project can be distributed using either [Crashlytics](http://support.crashlytics.com/knowledgebase/articles/388925-beta-distributions-with-gradle) or the [Google Play Store](https://github.com/Triple-T/gradle-play-publisher).

### Play Store

We use the __Gradle Play Publisher__ plugin. Once set up correctly, you will be able to push new builds to
the Alpha, Beta or production channels like this

```
./gradlew publishApkRelease
```
Read [plugin documentation](https://github.com/Triple-T/gradle-play-publisher) for more info.

### Crashlytics

You can also use Fabric's Crashlytics for distributing beta releases. Remember to add your fabric
account details to `app/src/fabric.properties`.

To upload a release build to Crashlytics run:

```
./gradlew assembleRelease crashlyticsUploadDistributionRelease
```

## New project setup 

To quickly start a new project from this boilerplate follow the next steps:

* Download this repository as a zip.
* Change the package name. 
  * Rename packages in main, androidTest and test using Android Studio.
  * In `app/build.gradle` file, `packageName` and `testInstrumentationRunner`.
  * In `src/main/AndroidManifest.xml` and `src/debug/AndroidManifest.xml`.
* Create a new git repository, [see GitHub tutorial](https://help.github.com/articles/adding-an-existing-project-to-github-using-the-command-line/).
* Replace the example code with your app code following the same architecture.
* In `app/build.gradle` add the signing config to enable release versions.
* Add Fabric API key and secret to fabric.properties and uncomment Fabric plugin set up in `app/build.gradle`
* Update `proguard-rules.pro` to keep models (see TODO in file) and add extra rules to file if needed.
* Update README with information relevant to the new project.
* Update LICENSE to match the requirements of the new project.

## License


