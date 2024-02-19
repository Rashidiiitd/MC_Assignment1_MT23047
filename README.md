# MC_Assignment1_MT23047
# First Assignment of Winter Semester of Mobile Computing Subject 
# TrainRouteMeter Android App
# Overview
TrainRouteMeter is an Android app built using Jetpack Compose that allows users to track the progress of a train route with a dynamic linear progress indicator.

# Project Structure
MainActivity.kt: The main activity class responsible for setting up the Compose UI.

# Data
stationList: List of Station objects representing train stations with their details.
Features
Dynamic Progress Indicator: Linear progress indicator showing the train route progress.
Unit Conversion: Toggle between kilometers and miles for distance units.
Navigation Buttons: Buttons to navigate to the previous and next stations.
Station Display: List of train stations with covered and remaining distances.

# Overview Of Working MyApp 
### MainActivity:

The entry point of the application.
Sets the content of the activity using the setContent function, where the main UI is composed using the Assignment_1_MC_MT23047Theme and MyApp functions.
StationItem:

Composable function to display information about a train station in a Card.
The color of the card changes based on whether the station is covered or not.
Station data class:

Represents a train station with properties like id, name, distanceCovered, and distanceRemaining.
stationList:

List of Station objects representing different stations along a train route.
### MyApp:

Main composable function that defines the overall layout and logic of the application.
Maintains the state of the current station index, progress in the route, and the selected unit (KM or Miles).
LinearProgressIndicator:

Displays a progress bar indicating the distance covered in the train route.
Top Row:

Displays the app name ("TrainRouteMeter") and a button to toggle between KM and Miles units.
Bottom Row with distances:

Displays the covered and remaining distances based on the selected unit (KM or Miles).
Bottom Row with navigation buttons:

Buttons for "Prev" and "Next" to navigate through the train stations.
The color of the buttons changes based on whether it's the first or last station.
#### LazyColumn:

A vertical scrolling list that displays StationItem for each station in the stationList.
The color of each StationItem changes based on whether the station is covered.
#### convertMilesToKilometers:

A utility function to convert distance from miles to kilometers.
#### onClick listeners for navigation buttons:

When the "Prev" button is clicked, the current index decreases, and progress is updated accordingly.
When the "Next" button is clicked, the current index increases, and progress is updated accordingly.
#### onClick listener for unit conversion button:

Toggles between KM and Miles units when the "Conversion" button is clicked.
#### Overall:

The UI dynamically updates based on the current station, progress, and unit settings.
Colors and text change to provide visual feedback to the user.
