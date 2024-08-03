package mo.ed.ismailia.yat.kotlin.feature.activity.overflow

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.feature.activity.search.SearchViewActivity

class OverFlowMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_over_flow_menu2)
    }

    /*
    onCreateOptionsMenu
    OnOptionsItemSelected
    OnPrepareOptionsMenu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search_menu_id -> openSearchView()
            R.id.edit_menu_id -> openEditView()
            R.id.remove_item_id -> openRemoveView()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openRemoveView() {
        Toast.makeText(this, "Removing ..", Toast.LENGTH_SHORT).show()
    }

    private fun openEditView() {
        Toast.makeText(this, "Editing ..", Toast.LENGTH_SHORT).show()
    }

    private fun openSearchView() {
        val intent = Intent(this, SearchViewActivity::class.java)
        startActivity(intent)

    }
}