package mo.ed.ismailia.yat.kotlin.feature.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.ismailia.yat.kotlin.R

class ExplicitIntentsActivity : AppCompatActivity() {
    lateinit var mapLauncher: ImageView
    lateinit var btnCall: ConstraintLayout
    lateinit var phoneEditText: EditText
    lateinit var btnMessaging: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explicit_intents)

        /*
        1. Exact Location using Google Map
        2. SMS text/plain
        3. Phone Call
         */

        mapLauncher = findViewById(R.id.mapLauncherImage)
        btnCall = findViewById(R.id.btnCall)
        phoneEditText = findViewById(R.id.phoneEditText)
        btnMessaging = findViewById(R.id.btnMessaging)

        mapLauncher.setOnClickListener { view ->
//,
            val lat = 30.620965701999165
            val long = 32.2905512223055
            val uri = Uri.parse("geo:$lat,$long")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }

        btnCall.setOnClickListener { view ->
            var phone = phoneEditText.text
            val uri = Uri.fromParts("tel", phone.toString(), null)
            val phoneIntent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(phoneIntent)
        }
        btnMessaging.setOnClickListener { view->
            var phone = phoneEditText.text
            val uri = Uri.fromParts("sms", phone.toString(), null)
            val smsIntent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(smsIntent)
        }
    }
}