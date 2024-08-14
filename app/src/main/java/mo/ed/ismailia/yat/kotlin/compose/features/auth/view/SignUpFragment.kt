package mo.ed.ismailia.yat.kotlin.compose.features.auth.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import mo.ed.ismailia.yat.kotlin.compose.features.auth.signup.signUpScreen
import mo.ed.ismailia.yat.kotlin.compose.uilistener.BaseUiInterface
import mo.ed.ismailia.yat.kotlin.utils.SessionManagement

class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val context = LocalContext.current
                signUpScreen(
                    signUpInterface = object : BaseUiInterface.SignUpUiInterface {
                        override fun onSignUpClicked(
                            email: String,
                            phoneNumber: String,
                            fullName: String
                        ) {
                            val session = SessionManagement(context)
                            session.putEmail(email)
                            session.putPhone(phoneNumber)
                            session.putUserName(fullName)
                            navigateToSignIn()
                        }
                    },
                    onBackPress = {
                        activity?.onBackPressedDispatcher?.onBackPressed()
                    }
                )
            }
        }
    }

    private fun navigateToSignIn() {
        val action = SignUpFragmentDirections.navigateFromSignUpScreenToSignInScreen()
        findNavController().navigate(action)
    }
}