package mo.ed.ismailia.yat.kotlin.feature.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mo.ed.ismailia.yat.kotlin.R

class GreetingsFragment : Fragment() {
    // onCreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.greeting_layout, container, false)
    }
}