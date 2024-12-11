package trpl.nim234311043.tracking_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import trpl.nim234311043.tracking_app.ui.theme.TrackingAppTheme
import trpl.nim234311043.tracking_app.Daypart
import trpl.nim234311043.tracking_app.ui.theme.TrackingAppTheme

val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrackingAppTheme {
                Surface(
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EventSummary()
                }
            }
        }
    }
}

//@Composable
//fun EventListDisplay() {
//    val events = mutableListOf(
//        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
//        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
//        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
//        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
//        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
//        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
//    )
//
//    val shortEvents = events.filter { it.durationInMinutes < 60 }
//
//    Column {
//        for (event in events) {
//            Text(text = event.toString())
//        }
//
//        Text(text = "Jumlah peristiwa: ${events.size}")
//
//        Text(text = "Anda memiliki ${shortEvents.size} peristiwa singkat.")
//    }
//}

@Composable
fun EventSummary() {
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    )
    println("Duration of first event of the day: ${events[0].durationOfEvent}")

    println("Last event of the day: ${events.last().title}")

    val eventsByDaypart = events.groupBy { it.daypart }


    Column {
        for ((daypart, eventsList) in eventsByDaypart) {
            Text(text = "$daypart: ${eventsList.size} events")
//            for (event in eventsList) {
//                Text(text = " - ${event.title} (${event.durationInMinutes} minutes)")
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrackingAppTheme {
        EventSummary()
    }
}
