package mo.ed.ismailia.yat.kotlin.feature.activity.swvl

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.NonCancellable
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.feature.activity.overflow.OverFlowMenuActivity
import mo.ed.ismailia.yat.kotlin.feature.fragment.DrawerFragment
import mo.ed.ismailia.yat.kotlin.feature.fragment.GreetingsFragment

class SwvlHomeActivity : AppCompatActivity() {

    lateinit var overflowLauncher : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_swvl_home)

        overflowLauncher = findViewById(R.id.overflowLauncher)


        overflowLauncher.setOnClickListener { view->
            val intent = Intent(this, OverFlowMenuActivity::class.java)
            startActivity(intent)
        }
        val greetingsFragment = GreetingsFragment()
        val drawerFragment = DrawerFragment()
        /*
        Fragment Manager
         */
        supportFragmentManager.beginTransaction()
            .add(R.id.greetingsFrame, greetingsFragment)
            .commitAllowingStateLoss()

        supportFragmentManager.beginTransaction()
            .add(R.id.drawerFrame, drawerFragment)
            .commit()
    }
}