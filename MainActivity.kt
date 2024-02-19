//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
package com.example.assignment_1_mc_mt23047

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment_1_mc_mt23047.ui.theme.Assignment_1_MC_MT23047Theme
import kotlin.math.roundToInt
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_1_MC_MT23047Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun StationItem(station: Station, isCovered: Boolean) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(if (isCovered) Color.Cyan else Color.Black) // Change color if it's the covered station
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = "${station.name} - Distance Covered: ${station.distanceCovered}",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
                    .background(if (isCovered) Color.Cyan else Color.Transparent) // Change text color if it's the covered station
            )
        }
    }
}



data class Station(
    val id: Int,
    val name: String,
    val distanceCovered: Int,
    val distanceRemaining: Int
)

val stationList =  listOf(
    Station(id = 0, name = "New Delhi", distanceCovered = 0, distanceRemaining = 150),
    Station(id = 1, name = "Ghaziabad", distanceCovered = 10, distanceRemaining = 140),
    Station(id = 2, name = "ModiNagar", distanceCovered = 20, distanceRemaining = 130),
    Station(id = 3, name = "MuradNagar", distanceCovered = 30, distanceRemaining = 120),
    Station(id = 4, name = "Meerut", distanceCovered = 40, distanceRemaining = 110),
    Station(id = 5, name = "Sakoti", distanceCovered = 50, distanceRemaining = 100),
    Station(id = 6, name = "Tanda", distanceCovered = 60, distanceRemaining = 90),
    Station(id = 7, name = "Daurala", distanceCovered = 70, distanceRemaining = 80),
    Station(id = 8, name = "Pabli Khas", distanceCovered = 80, distanceRemaining = 70),
    Station(id = 9, name = "Khautuali", distanceCovered = 90, distanceRemaining = 60),
    Station(id = 10, name = "Muzaffarnagar", distanceCovered = 100, distanceRemaining = 50),
    Station(id = 11, name = "deoband", distanceCovered = 110, distanceRemaining = 40),
    Station(id = 12, name = "Tawli", distanceCovered = 120, distanceRemaining = 30),
    Station(id = 13, name = "Sarsawa", distanceCovered = 130, distanceRemaining = 20),
    Station(id = 14, name = "Shahranpur", distanceCovered = 140, distanceRemaining = 10),
    Station(id = 15, name = "Haridwar", distanceCovered = 150, distanceRemaining = 0)
)


@Composable
fun MyApp() {
    var currentIndex by remember { mutableIntStateOf(0) }
    val currentStation = stationList[currentIndex]

    var progress by remember { mutableFloatStateOf(currentStation.distanceCovered.toFloat() / 150) }

    // State to track the current unit ("KM" or "Miles")
    var currentUnit by remember { mutableStateOf("KM") }

    // Function to convert miles to kilometers
    fun convertMilesToKilometers(miles: Int): Int {
        // Conversion logic
        return (miles * 1.60934).roundToInt()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        // Top Row with "TrainRouteMeter" text and "Conversion" button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "TrainRouteMeter",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    // Toggle between "KM" and "Miles" when the button is pressed
                    currentUnit = if (currentUnit == "KM") "Miles" else "KM"
                },
                modifier = Modifier
                    .padding(end = 8.dp)
                    .height(40.dp)
            ) {
                Text("Conversion", fontSize = 14.sp)
            }
        }

        // Determinant Indicator Progress Bar
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        // Bottom Row with covered and remaining distances
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Display distances based on the current unit
            val coveredDistance =
                if (currentUnit == "KM") "${currentStation.distanceCovered} KM"
                else "${convertMilesToKilometers(currentStation.distanceCovered)} Miles"

            val remainingDistance =
                if (currentUnit == "KM") "${currentStation.distanceRemaining} KM"
                else "${convertMilesToKilometers(currentStation.distanceRemaining)} Miles"

            Text("Covered = ${coveredDistance}", fontSize = 12.sp)
            Text("RemDistance = ${remainingDistance}", fontSize = 12.sp)
        }

        // Bottom Row with "Start" and "Prev" buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom // Align buttons to the bottom
        ) {
            Button(
                onClick = {
                    currentIndex = (currentIndex - 1).coerceIn(0, stationList.size - 1)
                    progress = stationList[currentIndex].distanceCovered.toFloat() / 150
                },
                modifier = Modifier
                    .height(48.dp)
                    .padding(horizontal = 8.dp)
                    .background(if (currentIndex == 0) Color.Red else Color.Gray) // Change color if it's the current station
            ) {
                Text("Prev", fontSize = 16.sp, color = Color.White)
            }

            Button(
                onClick = {
                    currentIndex = (currentIndex + 1).coerceIn(0, stationList.size - 1)
                    progress = stationList[currentIndex].distanceCovered.toFloat() / 150
                },
                modifier = Modifier
                    .height(48.dp)
                    .padding(horizontal = 8.dp)
                    .background(if (currentIndex == stationList.size - 1) Color.Red else Color.Gray) // Change color if it's the current station
            ) {
                Text("Next", fontSize = 16.sp, color = Color.White)
            }
        }

        LazyColumn {
            items(stationList.size) { index ->
                val station = stationList[index]
                val isCovered = index <= currentIndex // Assuming covered means up to the current index
                StationItem(station = station, isCovered = isCovered)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}

