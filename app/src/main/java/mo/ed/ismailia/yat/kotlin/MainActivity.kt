package mo.ed.ismailia.yat.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
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

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawerLayout: DrawerLayout
    lateinit var  actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.detail_toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.dawerLayout)
        navigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationIcon(R.drawable.ic_drawer)

        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.nav_open, R.string.nav_close)

        // ad a drawer listener
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        actionBarDrawerToggle.setToolbarNavigationClickListener { view->
            if (drawerLayout.isDrawerVisible(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        actionBarDrawerToggle.setDrawerIndicatorEnabled(false)
        actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_drawer)
        // show menu icon and back icon while drawer open

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.trips -> Toast.makeText(this, "Trips", Toast.LENGTH_SHORT).show()
            R.id.notifications -> Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
            R.id.overFlow -> openOverFlowScreen()
            R.id.sign_out -> Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    private fun openOverFlowScreen() {
        val intent = Intent(this, OverFlowMenu::class.java)
        startActivity(intent)
    }
}