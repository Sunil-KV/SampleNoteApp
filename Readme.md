# Sample Note App

Hi,

Thanks for checking out my project.
For the rest of this document, I will be explaining the
reasons for the technical decisions I made for this case study, the problems I faced, and what
I learnt from them.

## Table of Contents
- [AppInfo](#appinfo)
- [Prerequisite](#prerequisite)
- [Architecture](#architecture)
- [Libraries](#libraries)

## Prerequisite
- Minimum Api Level : 21
- compileSdkVersion : 31
- Build System : [Gradle](https://gradle.org/)

## AppInfo

This is a simple Notes App. Users will be able to add a note with Title and description.
Users can edit the note and delete the note as well.

## Architecture

The Application follows MVVM architecture.

Activities acts as UI controller to display UI data and forward on UI events.
RecycleView is used to display the list of Notes as its very effective to implement scrollable lists.

The ViewModel handles the UI logic and provides data via Android architectural component LiveData to the view.
The reason for using the `Jetpack Viewmodel` is that it survives configuration changes,
and thus ensures that the view state is persisted across screen rotation

Repository class acts as single source of truth for all app data and provides clean API for UI to communicate with
Room data base is used as a local data source for storing the users data.
Kotlin Coroutines used for asynchronous programming.

## Libraries

Libraries used in the application are:

- [Jetpack](https://developer.android.com/jetpack)
- [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle conscious way
      and act as a channel between use cases and UI.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Provides an observable data holder class.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines. I used this for asynchronous programming in order
  to obtain data from the database.
- [Room](https://developer.android.com/jetpack/androidx/releases/room) - Room Database is an improvised version of SQLite Database. 
  It simplifies the database work and serves as an access point to the underlying SQLite database  