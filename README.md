# Supertal Practical ![](https://img.shields.io/github/issues/niraj-prajapati/SupertalPractical) ![](https://img.shields.io/github/forks/niraj-prajapati/SupertalPractical) ![](https://img.shields.io/github/stars/niraj-prajapati/SupertalPractical) ![](https://img.shields.io/github/repo-size/niraj-prajapati/SupertalPractical) ![](https://img.shields.io/tokei/lines/github/niraj-prajapati/SupertalPractical) ![](https://img.shields.io/github/languages/top/cortinico/kotlin-android-template)

A Practical code for interview at Supertal where,
- mockapi returns list of users containing `name` and `imageUrl`
- main screen should show list of users fetched
- clicking on any user should redirect to user detail screen
- user detail screen should show image and name there

## API Reference

API is hosted on [beeceptor.com](https://beeceptor.com/)

#### Get all users

```https://supertal.free.beeceptor.com/
  GET /users
```

## Built With

- Kotlin - First class and official programming language for Android development.
- Navigation - framework for navigating between destinations within an Android application.
- Coroutines - For asynchronous and more..
- Flow - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- Android Architecture Components - Collection of libraries that help you design robust, testable, and maintainable apps.
    - LiveData - Data objects that notify views when the underlying database changes.
    - ViewModel - Stores UI-related data that isn't destroyed on UI changes.
    - ViewBinding - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
- Hilt-Dagger - Standard library to incorporate Dagger dependency injection into an Android application.
- Retrofit - A type-safe HTTP client for Android and Java.
- Glide - An image loading library for Android.

## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)


## Package Structure

```
com.supertal.practical  # Root Package MainActivity and application class
.
├── base                # For base activity, fragment and viewmodel
├── data                # For data handling
├── di                  # Dependency Injection    
├── model               # Model classes
├── network             # API url, endpoints and service
├── ui                  # Activity/View layer
│   ├── main            # Main Screen fragment, adapter & viewmodel
│   └── userdetails     # User Detail Screen fragment and viewmodel
└── utils               # Utility classes
```
## Screenshots

Light                        |Dark                      | Demo
:--------------------------:|:-------------------------:|:-------------------------:
<img width="270" height="585" src="https://raw.githubusercontent.com/niraj-prajapati/SupertalPractical/master/graphics/main%20screen%20light.png">  |  <img width="270" height="585" src="https://raw.githubusercontent.com/niraj-prajapati/SupertalPractical/master/graphics/main%20screen%20dark.png"> | <img width="270" height="585" src="https://github.com/niraj-prajapati/SupertalPractical/blob/master/graphics/app%20functions.gif?raw=true">
<img width="270" height="585" src="https://raw.githubusercontent.com/niraj-prajapati/SupertalPractical/master/graphics/user%20detail%20screen%20light.png"> |<img width="270" height="585" src="https://raw.githubusercontent.com/niraj-prajapati/SupertalPractical/master/graphics/user%20detail%20screen%20dark.png">

## Clone and Run

Clone the project

- Open Android Studio
- File > New > Project from Version Control
- Enter url https://github.com/niraj-prajapati/SupertalPractical.git
- click Clone

Alternatively, run command in terminal and open project in Android Studio

```bash
  git clone https://github.com/niraj-prajapati/SupertalPractical.git
```
Then run App in Device or Emulator


## Contributing

Contributions are always welcome!
## Authors

- [@niraj-prajapati](https://github.com/niraj-prajapati)


## Feedback

If you have any feedback, please reach out to us at niraj06081995@gmail.com

