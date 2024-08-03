package mo.ed.ismailia.yat.kotlin

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class OverFlowMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_over_flow_menu)


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.edit_menu_id -> Toast.makeText(this,"Edit",Toast.LENGTH_SHORT).show()
            R.id.remove_item_id -> Toast.makeText(this,"Remove",Toast.LENGTH_SHORT).show()
            R.id.search_menu_id -> searchWeb(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun searchWeb(item: MenuItem) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, "pizza")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}