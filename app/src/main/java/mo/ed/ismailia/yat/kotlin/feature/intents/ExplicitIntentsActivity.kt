package mo.ed.ismailia.yat.kotlin.feature.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.ismailia.yat.kotlin.R

class ExplicitIntentsActivity : AppCompatActivity() {
    lateinit var mapLauncher: ImageView
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
        mapLauncher.setOnClickListener { view ->
//,
            val lat = 30.620965701999165
            val long = 32.2905512223055
            val uri = Uri.parse("geo:$lat,$long")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }
    }
}