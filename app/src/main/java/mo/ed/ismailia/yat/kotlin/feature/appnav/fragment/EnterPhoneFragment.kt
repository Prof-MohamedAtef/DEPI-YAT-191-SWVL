package mo.ed.ismailia.yat.kotlin.feature.appnav.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.utils.Constants

class EnterPhoneFragment : Fragment() {
    lateinit var editPhone: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.enter_phone_fagment, container, false)
        editPhone = view.findViewById(R.id.editPhoneNumber)

        val phoneNumber = Constants.EGYPT_COUNTRY_CODE + editPhone.text.toString()

        return view
    }
}