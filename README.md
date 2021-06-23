# The Shoe Store

This project will consist of five screens. You don't have to create a shoe store, you can use any other item as long as you create the following screens. You will be creating:

1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Shoe Listing screen
5. Shoe Detail screen for adding a new shoe

## Getting Started

Open the starter project in the latest stable version of Android Studio.

Open the starter project in Android Studio

## Steps

- [x] Open the starter project in Android Studio

- [x] Add the navigation libraries to the app build.gradle file

- [x] Add the safe-arg plugin to the main and app build.gradle file

- [x] Create a new navigation xml file

- [x] Create a new Login destination.

   - [x] Include email and password labels 
   - [x] Include email and password fields
   - [x] Create buttons for creating a new login and logging in with an existing account
   - [x] Clicking either button should navigate to the Welcome Screen.

- [x] Create a new Welcome screen destination that includes:

   - [x] A new layout
   - [x] At least 2 textviews
   - [x] A navigation button with actions to navigate to the instructions screen

- [x] Create a new Instruction destination that includes:

   - [x] A new layout
   - [x] At least 2 textviews
   - [x] A navigation button with actions to navigate to the shoe list screen

- [x] Create a class that extends ViewModel

   - [x]  Use a LiveData field that returns the list of shoes

- [x] Create a new Shoe List destination that includes:

   - [x] A new layout
   - [x] A ScrollView
   - [x] A LinearLayout for Shoe Items
   - [x] A FloatingActionButton with an action to navigate to the shoe detail screen

- [x] In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

- [ ] Create a new Shoe Detail destination that includes:

    - [x] A new layout
    - [x] A TextView label and EditView for the
      - [x] Shoe Name
      - [x] Company
      - [x] Shoe Size
      - [x] Description
    - [ ] A Cancel button with an action to navigate back to the shoe list screen
    - [ ] A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model

- [ ] Make sure you can’t go back to onboarding screens

- [ ] In the Shoe List screen:

    - [x] Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
    - [x] Observe the shoes variable from the ViewModel
    - [x] Use DataBindingUtil to inflate the shoe_list layout
    - [ ] Add a new layout item into the scrollview for each shoe.
    
- [ ] Make the layouts look pretty.