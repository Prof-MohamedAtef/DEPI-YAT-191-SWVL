package mo.ed.ismailia.yat.kotlin.feature.activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.feature.model.Trip

class SecondScreenActivity : AppCompatActivity() {

    lateinit var textViewShow: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)
        textViewShow = findViewById(R.id.tvShow)

//        val tripId = intent.getStringExtra("tripId")
        val tripKey = intent.extras?.getSerializable("TRIP_KEY") as Trip
//        val carNumber =  intent.extras?.getInt("CarNumber", 0)
//        Log.e("TripID: ", tripId.toString())


        textViewShow.text = "TripId: ${tripKey.tripID} ,\n" +
                "Departure Time: ${tripKey.departureTime},\n" +
                "Arrival Time: ${tripKey.arrivalTime},\n" +
                "Driver Name: ${tripKey.driverName},\n" +
                "Pickup Address: ${tripKey.pickupAddress},\n" +
                "Destination Address: ${tripKey.destinationAddress},\n"
    }
}