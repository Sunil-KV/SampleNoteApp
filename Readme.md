# Simple Note App

Hi,

Thanks for checking out my project.
For the rest of this document, I will be explaining the
reasons for the technical decisions I made for this case study, the problems I faced, and what
I learnt from them.

## Table of Contents
- [Prerequisite](#prerequisite)
- [Architecture](#architecture)
- [Libraries](#libraries)

## Prerequisite
- Minimum Api Level : 21
- compileSdkVersion : 31
- Build System : [Gradle](https://gradle.org/)

## Architecture

The Application follows MVVM architecture.

Activities acts as UI controller to display UI data and forward on UI events.

The ViewModel handles the UI logic and provides data via Android architectural component LiveData to the view.
The reason for using the `Jetpack Viewmodel` is that it survives configuration changes,
and thus ensures that the view state is persisted across screen rotation

Repository class acts as single source of truth for all app data and provides clean API for UI to communicate with

Room data base is used as a local data source for storing the users data.

Kotlin Coroutines used for asynchronous programming.

