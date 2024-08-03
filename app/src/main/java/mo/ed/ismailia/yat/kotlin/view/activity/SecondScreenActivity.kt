package mo.ed.ismailia.yat.kotlin.view.activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.ismailia.yat.kotlin.R

class SecondScreenActivity : AppCompatActivity() {

    lateinit var textViewShow: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)
        val tripId = intent.getStringExtra("tripId")

        val carNumber =  intent.extras?.getInt("CarNumber", 0)

//        Log.e("TripID: ", tripId.toString())

        textViewShow = findViewById(R.id.tvShow)

        textViewShow.text = "TripIdL $tripId,\n" +
                "CarNumber: $carNumber"


    }
}