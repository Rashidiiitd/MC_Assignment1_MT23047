/*

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
data class Station(
    val id: Int,
    val name: String,
    val distanceCovered: Int,
    val distanceRemaining: Int
)
val stationList = listOf(
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
fun StationList() {
    LazyColumn {
        items(stationList.size) { index ->
            val station = stationList[index]
            StationItem(station = station)
            // Add a Spacer with height to create space between Card elements
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun StationItem(station: Station) {
    Card( modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
    ) {
        Text(
            text = "${station.name} ",
            modifier = Modifier
                .padding(16.dp)
                //.weight(1f)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewStationList() {
    StationList()
}*/
