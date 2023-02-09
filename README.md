![OS](https://badgen.net/badge/OS/Android?icon=https://raw.githubusercontent.com/androiddevnotes/awesome-android-kotlin-apps/master/assets/android.svg&color=3ddc84)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.7.21-blue.svg)](http://kotlinlang.org)
![Language](https://img.shields.io/github/languages/top/cortinico/kotlin-android-template?color=blue&logo=kotlin)


# Project 1 Kotlin of CVBB : Leviosa !

## Table des matières

1. [Getting Started](#getting-started)
2. [Contexte](#contexte)
3. [Introduction](#introduction)
4. [Contributors](#contributors)
5. [Best Practices](#best-practices)
6. [Technologies](#technologies)  
7. [Architecture](#architecture)  
8. [Dependencies](#dependencies)  
9. [Showtime](#showtime)  
10. [Coming](#coming) 
11. [Contact](#contact)  

## Getting Started

This is an _Android_ project made with _Kotlin_ language.

### Prerequisites

Install [Android Studio](https://developer.android.com/studio), see instructions.

### Installation

1. Clone the repo
   ```sh
   git clone https://gitlab.com/Clara1606/projet-1-kotlin.git
   ```
2. Choose, _Open an Existing Project_ in _Android Studio_ 

## Context
For the first level 2 mobile development project of this year, we are coding a native android app with Kotlin.

## Introduction
Our app is Harry Potter themed.
Throughout your immersion, you will be in the magic of Hogwarts.
To see available, a [Quiz](#Quiz) to know your house
The list of the most famous [spells](#Lists) and finally the list of the best [wizards](#Lists).


## Contributors
- Bastien BRUNET M1 Développement Logiciel, Mobile et IOT
- Clara VESVAL M1 Développement Logiciel, Mobile et IOT

We know each other since the start of third year and are used to work together.
We are complementary.

## Best Practices

It's all on the branch main.

We have to foolow the good practices of an android and kotlin project.
- [X] Customize color in App bar
- [X] Change the launcher icon
- [X] Add a language
- [X] Use of string.xml (/!\ hard coded var /!)
- [X] Coherence in naming convention (See naming convention of [Kotlin for Android project](https://gitlab.com/chillcoding-at-the-beach/kotlin-for-android/-/wikis/Naming-Convention).)
- [X] Code in english
- [X] Use of versions variables in Gradle files
- [X] Read me
- [X] GIT Flow
- [X] Commits on GIT 
- [X] Menu
- [X] Use of layouts 
- [X] Use of cards, alert dialog and other Material Design items 
- [X] Use of the ViewBinding
- [X] Kotlin concepts (array, lateinit, inline fun, with(), when(), also, etc.)  
 - [X] App class
 - [X] Compose 
 - [X] RecyclerView
 - [X] DataStore


## Technologies
We are using Android Studio Electrical Eel (Be careful if you're not using this version, there could be some compatibility issues)
We are compiling in Android 33, our target is Android 33
Gradle Version : 7.5

## Dependencies

### Libraries
  * [Glide to redimissesier an image](https://github.com/bumptech/glide)
  * Gif (pl.droidsonroids.gif:android-gif-drawable)
  * Compose (androidx.compose:compose-bom:2022.12.00)
  * DataStore (androidx.datastore:datastore-preferences:1.0.0)

### Other
  * [View Binding, Part of Android Jetpack](https://developer.android.com/topic/libraries/view-binding)

## Architecture
Our application is available in English and French

### Quiz
We have a home page as well as a page to gain access to our awesome quiz that will reveal which Hogwart house you belong to !
During this quiz, you will answer to a number of questions in order to discover if you are a ~~Slytherin~~ or a Gryffindor :)

We are using the differents widgets available for android to build a complete form :
- RadioButton
- EditText
- Image
- CheckBox
- Switch
- Spinner
- AutoComplete

There are also questions with pictures to choose from!
And even gifs to illustrate the question

Each answer is worth a certain amnount of points, that's how we can determine which is yours !

### Menu

Before we only worked with Activities, when we had to do the menu, we switched to Fragments and ViewModel
For the menu of our application, we opted for:
- OptionMenu
- NavigationDrawer


### Lists
For the rest of the exercise, we wanted to stay in the Harry Potter universe.

For the part concerning the lists of elements, we wanted to make the 2 possibilities:
- With the RecyclerView and Adapter (with wizard list)
- With Compose (with the list of spells)

### Settings
The settings page allows you to input your name so you don't have to do it each time you launch a new quiz.

This feature is implemented using the preferences datastore and can be accessed via a menu located on the top right of the app.

## Showtime
Here is a simple demonstration of how the app is designed to be used, starting from the home screen to the end result :

### V1 (only first project and quiz) (27/01/2023)
<img src="./readme_images/gifV1.gif" alt="gifV1" width="200" />

### V2 (menu and lists) (03/02/2023)
<img src="./readme_images/gifV1.gif" alt="gifV2" width="200" />

### V3 (Settings) (09/02/2023 at 12h30)
<img src="./readme_images/gifV1.gif" alt="gifV3" width="200" />


## Coming 

For the rest, we are going to make a new application, taking up all the good practices and pushing certain concepts further.
We are going to create "Mouvie", an application that will allow you to find films, know the most popular of the moment and finally be able to put them in favorites.
For more details you can see our [ReadMe](https://gitlab.com/Clara1606/mouvie-kotlin)

## Contact 

Clara Vesval, on (https://clara-1606.github.io/) [![LinkedIn][linkedin-shield]][linkedin-url-clara].  
Bastien Brunet [![LinkedIn][linkedin-shield]][linkedin-url-bastien].

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url-clara]: https://www.linkedin.com/in/clara-vesval-84b911193/
[linkedin-url-bastien]: https://www.linkedin.com/in/bastienbrunet/
