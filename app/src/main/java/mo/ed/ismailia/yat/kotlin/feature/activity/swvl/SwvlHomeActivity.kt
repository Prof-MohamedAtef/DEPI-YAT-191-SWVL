package mo.ed.ismailia.yat.kotlin.feature.activity.swvl

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.NonCancellable
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.feature.activity.overflow.OverFlowMenuActivity
import mo.ed.ismailia.yat.kotlin.feature.activity.swvl.view.fragment.CitiesFragment
import mo.ed.ismailia.yat.kotlin.feature.fragment.DrawerFragment
import mo.ed.ismailia.yat.kotlin.feature.fragment.GreetingsFragment
import kotlin.math.truncate

class SwvlHomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var navigationView: NavigationView

    //citiesFrame

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_swvl_home)
        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationIcon(R.drawable.ic_drawer)

        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.nav_open,
            R.string.nav_close
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        actionBarDrawerToggle.setToolbarNavigationClickListener { view ->
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        actionBarDrawerToggle.setDrawerIndicatorEnabled(false)
        actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_drawer)

//        overflowLauncher.setOnClickListener { view ->
//            val intent = Intent(this, OverFlowMenuActivity::class.java)
//            startActivity(intent)
//        }
        val greetingsFragment = GreetingsFragment()
        val citiesFragment = CitiesFragment()

        /*
        Fragment Manager
         */
        supportFragmentManager.beginTransaction()
            .add(R.id.greetingsFrame, greetingsFragment)
            .commitAllowingStateLoss()

        supportFragmentManager.beginTransaction()
            .add(R.id.citiesFrame, citiesFragment)
            .commitAllowingStateLoss()



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.your_trips_menu_id -> Toast.makeText(this, "Trips", Toast.LENGTH_SHORT).show()
            R.id.wallet_menu_id -> Toast.makeText(this, "Wallet", Toast.LENGTH_SHORT).show()
            R.id.payment_menu_id -> Toast.makeText(this, "Payment", Toast.LENGTH_SHORT).show()
            R.id.your_packages_menu_id -> Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            R.id.your_private_bus_menu_id -> Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            R.id.your_settings_id -> Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            R.id.help_id -> Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            R.id.privacy_center_id -> Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}