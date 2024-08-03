package mo.ed.ismailia.yat.kotlin.feature.activity.swvl

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.feature.fragment.DrawerFragment
import mo.ed.ismailia.yat.kotlin.feature.fragment.GreetingsFragment

class SwvlHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_swvl_home)

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