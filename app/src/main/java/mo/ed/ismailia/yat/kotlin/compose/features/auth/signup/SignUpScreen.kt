package mo.ed.ismailia.yat.kotlin.compose.features.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import mo.ed.ismailia.yat.kotlin.compose.base.appbar.AppToolBar
import mo.ed.ismailia.yat.kotlin.compose.base.theme.AppTheme
import mo.ed.ismailia.yat.kotlin.compose.base.theme.swvlColorDegree
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.compose.base.AppText
import mo.ed.ismailia.yat.kotlin.compose.base.FontStyle
import mo.ed.ismailia.yat.kotlin.compose.uilistener.BaseUiInterface

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signUpScreen(
    signUpInterface: BaseUiInterface.SignUpUiInterface? = null,
    onBackPress: () -> Unit = {},
) {
    AppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppToolBar(
                    title = "Sign up",
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = swvlColorDegree),
                    modifier = Modifier.fillMaxWidth(),
                    onBackPressed = onBackPress
                )
            },
            content = { paddingValues ->
                signUpBody(
                    paddingValues,
                    signUpInterface = signUpInterface
                )
            }
        )
    }
}

@Composable
fun signUpBody(
    paddingValues: PaddingValues,
    signUpInterface: BaseUiInterface.SignUpUiInterface? = null,
) {
    var phoneNumber by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
            .fillMaxHeight()
            .background(colorResource(id = R.color.white))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            AppText(
                fontStyle = FontStyle.BaseTextMediumHeading3,
                text = stringResource(id = R.string.sign_up),
                color = colorResource(id = R.color.black),
                modifier = Modifier
                    .padding(top = 62.dp)
                    .align(Alignment.CenterHorizontally)
                    .wrapContentWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = {
                    AppText(
                        fontStyle = FontStyle.BaseTextMediumHeading3,
                        text = stringResource(id = R.string.enter_full_name),
                        color = colorResource(id = R.color.white),
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    AppText(
                        fontStyle = FontStyle.BaseTextMediumHeading3,
                        text = stringResource(id = R.string.enter_email),
                        color = colorResource(id = R.color.white),
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = {
                    AppText(
                        fontStyle = FontStyle.BaseTextMediumHeading3,
                        text = stringResource(id = R.string.enter_phone_number),
                        color = colorResource(id = R.color.white),
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    if (email.length != 0 && phoneNumber.length != 0 && fullName.length != 0) {
                        signUpInterface?.onSignUpClicked(email, phoneNumber, fullName)
                    } else {
                        /*show Toast message*/
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign Up")
            }
        }
    }
}

@Preview
@Composable
fun PreviewSignUpScreen() {
    signUpScreen()
}