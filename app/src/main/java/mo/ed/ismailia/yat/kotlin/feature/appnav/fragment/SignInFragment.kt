package mo.ed.ismailia.yat.kotlin.feature.appnav.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.utils.SessionManagement

class SignInFragment : Fragment() {
    private lateinit var tvEnterYouNumber : TextView
    private lateinit var btnGoogle: LinearLayout
    private lateinit var btnFacebook: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.signin_fragment, container, false)
        tvEnterYouNumber = view.findViewById(R.id.tvEnterYouNumber)
        btnGoogle = view.findViewById(R.id.btnGoogle)
        btnFacebook = view.findViewById(R.id.btnFacebook)

        val session = activity?.let { SessionManagement(it) }
        val phone = session?.getPhone()
        tvEnterYouNumber.text = phone
        btnGoogle.setOnClickListener { view->
            val action = SignInFragmentDirections.navigateFromSignInScreenToSignUpScreen()
            findNavController().navigate(action)
        }
        btnFacebook.setOnClickListener { view->
            val action = SignInFragmentDirections.navigateFromSigninScreenToTripsScreen()
            findNavController().navigate(action)
        }
        tvEnterYouNumber.setOnClickListener { view->
            val action = SignInFragmentDirections.navigateFromSignInScreenToEnterPhoneScreen()
            findNavController().navigate(action)
        }
        return view
    }
}