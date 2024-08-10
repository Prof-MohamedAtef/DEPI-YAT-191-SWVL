package mo.ed.ismailia.yat.kotlin.feature.appnav.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import mo.ed.ismailia.yat.kotlin.R

class SwvlNavigationActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_swvl_navigation)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

        Log.e("onCreate Call", "OnCreate is Called")
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart Call", "OnStart is Called")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume Call", "onResume is Called")
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause Call", "onPause is Called")
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop Call", "onStop is Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy Call", "onDestroy is Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart Call", "onRestart is Called")
    }
}