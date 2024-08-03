package mo.ed.ismailia.yat.kotlin.feature.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.feature.model.Trip

class FirstScreenActivity : AppCompatActivity() {
    lateinit var sendDataBTN: Button
    lateinit var editTripID: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_screen)

        /*
        inflating layout on kotlin/java files
         */
        sendDataBTN = findViewById(R.id.btnSendData)
        editTripID = findViewById(R.id.edit_trip_id)

        sendDataBTN.setOnClickListener { view->
            var tripID = editTripID.text
//            Intent

            val intent = Intent(this, SecondScreenActivity::class.java).apply {
//                putExtra("tripId", tripID.toString())
            }

            /*
            Bundle
             */
            val bundle = Bundle()
            bundle.putInt("CarNumber", 5060)

            val trip = Trip(tripID.toString(),"50:00PM","07:00PM","Yasser","Ismailia","Cairo")
            bundle.putSerializable("TRIP_KEY", trip)
            /*
            Serializable Data
            Parcelable Data - overview
             */

            intent.putExtras(bundle)

            startActivity(intent)

        }

    }
}