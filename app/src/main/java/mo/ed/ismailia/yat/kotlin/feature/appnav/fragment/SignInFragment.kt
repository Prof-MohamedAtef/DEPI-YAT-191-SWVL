package mo.ed.ismailia.yat.kotlin.feature.appnav.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import mo.ed.ismailia.yat.kotlin.R

class SignInFragment : Fragment() {
    private lateinit var tvEnterYouNumber : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.signin_fragment, container, false)
        tvEnterYouNumber = view.findViewById(R.id.tvEnterYouNumber)
        tvEnterYouNumber.setOnClickListener { view->
            val action = SignInFragmentDirections.navigateFromSignInScreenToEnterPhoneScreen()
            findNavController().navigate(action)
        }
        return view
    }
}