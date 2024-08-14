package mo.ed.ismailia.yat.kotlin.compose.uilistener

interface BaseUiInterface {
    interface SignUpUiInterface{
        fun onSignUpClicked(email: String, phoneNumber: String, fullName: String)
    }
}