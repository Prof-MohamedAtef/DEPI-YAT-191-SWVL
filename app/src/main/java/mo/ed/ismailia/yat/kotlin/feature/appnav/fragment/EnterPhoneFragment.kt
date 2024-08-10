package mo.ed.ismailia.yat.kotlin.feature.appnav.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mo.ed.ismailia.yat.kotlin.R

class EnterPhoneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.enter_phone_layout, container, false)
        return view
    }



}