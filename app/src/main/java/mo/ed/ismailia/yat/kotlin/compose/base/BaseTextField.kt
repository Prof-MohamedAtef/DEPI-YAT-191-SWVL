package mo.ed.nozha.apps.compose.base

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.R.*
import mo.ed.ismailia.yat.kotlin.compose.base.AppText
import mo.ed.ismailia.yat.kotlin.compose.base.FontStyle
import mo.ed.ismailia.yat.kotlin.compose.base.theme.stcForwardFamily

enum class TextFieldStyle{
    TextTextField,
    TextTextFieldWithError,
    NumberTextFiled,
    NumberTextFieldWithError,
    NumberTextFieldWithTextFieldValue,
    PasswordTextField,
    PasswordTextFieldWithError,
    PasswordTextFieldWithProgressBarWithError,
    LoginPasswordTextField,
    LoginPasswordTextFieldWithError,

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTextField(
    textFieldStyle: TextFieldStyle,
    modifier: Modifier,
    value: String,
    textStyle: TextStyle,
    isError: Boolean = false,
    errorMsg: String = "",
    progress: Float = 0f,
    progressBarColor: Color = colorResource(id = color.white),
    trackColor: Color = colorResource(id = color.white),
    progressHint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    textFieldBackgroundColor: Int = color.base_3,
    cursorColor:Int= color.useful_nums_text_color,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    isArabic: Boolean = false,
    onValueChange: (String) -> Unit)
{

    when (textFieldStyle) {
        TextFieldStyle.TextTextField -> TextTextField( modifier = modifier, value = value,textStyle =textStyle, keyboardType = keyboardType, onValueChange =onValueChange,textFieldBackgroundColor = textFieldBackgroundColor, placeholder = placeholder,cursorColor=cursorColor, label = label)
        TextFieldStyle.TextTextFieldWithError -> TextTextFieldWithError(modifier = modifier,value = value, isError = isError, keyboardType = keyboardType, errorMsg = errorMsg, textFieldBackgroundColor = textFieldBackgroundColor,textStyle = textStyle, onValueChange = onValueChange, placeholder = placeholder, label = label)
        TextFieldStyle.NumberTextFieldWithError -> NumberTextFieldWithError(modifier = modifier,value = value, isError = isError, errorMsg = errorMsg, textStyle = textStyle, onValueChange = onValueChange, placeholder = placeholder, label = label)
        TextFieldStyle.NumberTextFiled -> NumberTextField(modifier = modifier, value = value, textStyle = textStyle, onValueChange = onValueChange, textFieldBackgroundColor = textFieldBackgroundColor, label = label, placeholder = placeholder)
        TextFieldStyle.PasswordTextField -> PasswordTextField(modifier = modifier, value = value, onValueChange = onValueChange, placeholder = placeholder, label = label)
        TextFieldStyle.PasswordTextFieldWithError -> PasswordTextFieldWithError(modifier = modifier, value = value, errorMsg = errorMsg, isError = isError, onValueChange = onValueChange, placeholder = placeholder, label = label)
        TextFieldStyle.PasswordTextFieldWithProgressBarWithError -> PasswordTextFieldWithProgressBarWithError(modifier = modifier,isError = isError, errorMsg = errorMsg, progress = progress, progressHint = progressHint, keyboardType= keyboardType, progressBarColor = progressBarColor, trackColor = trackColor, textStyle = textStyle, onValueChange = onValueChange, value = value, placeholder = placeholder, label = label)
        TextFieldStyle.LoginPasswordTextField -> LoginPasswordTextField(modifier = modifier, value = value, onValueChange = onValueChange, placeholder = placeholder, label = label)
        TextFieldStyle.LoginPasswordTextFieldWithError -> LoginPasswordTextFieldWithError(modifier = modifier, value = value, errorMsg = errorMsg, isError = isError, onValueChange = onValueChange, placeholder = placeholder, label = label, isArabic = isArabic)

        else -> {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTextFieldWithTextFieldValue(
    textFieldStyle: TextFieldStyle,
    modifier: Modifier,
    value: TextFieldValue,
    textStyle: TextStyle,
    isError: Boolean = false,
    errorMsg: String = "",
    progress: Float = 0f,
    progressBarColor: Color = colorResource(id = color.white),
    trackColor: Color = colorResource(id = color.white),
    progressHint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    textFieldBackgroundColor: Int = color.base_3,
    label: @Composable (() -> Unit)? = null,
    onValueChange: (TextFieldValue) -> Unit)
{

    when (textFieldStyle) {
        TextFieldStyle.NumberTextFieldWithTextFieldValue -> NumberTextFieldWithTextFieldValue(modifier = modifier, value = value, textStyle = textStyle, onValueChange = onValueChange, textFieldBackgroundColor = textFieldBackgroundColor, label = label)
        else -> {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextTextField(
    modifier: Modifier,
    value: String,
    textStyle: TextStyle,
    keyboardType: KeyboardType = KeyboardType.Text,
    isSingleLine: Boolean = true,
    textFieldBackgroundColor: Int = color.base_3,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    cursorColor: Int= color.useful_nums_text_color,
    onValueChange: (String) -> Unit
){
    Column{
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            label = label,
            shape = RoundedCornerShape(4.dp),
            placeholder = placeholder
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberTextFieldWithError(
    modifier: Modifier,
    value: String,
    errorMsg: String,
    textStyle: TextStyle,
    keyboardType: KeyboardType = KeyboardType.Number,
    isError: Boolean = false,
    isSingleLine: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    textFieldBackgroundColor: Int = color.base_3,
    cursorColor: Int= color.useful_nums_text_color,
){

    var errorColor = colorResource(id = color.transparent)
    if (isError) errorColor = colorResource(id = color.danger_500)

    Column{
        TextField(
            modifier = modifier.border(
                width = 1.dp,
                color = errorColor,
                shape = RoundedCornerShape(4.dp)
            ),
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(4.dp),
            placeholder = placeholder
        )

        if (isError){
            AppText(
                modifier = Modifier
                    .padding( top = 8.dp),
                fontStyle = FontStyle.BaseTextMediumBody3,
                text = errorMsg,
                color = errorColor
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextTextFieldWithError(
    modifier: Modifier,
    value: String,
    errorMsg: String,
    textStyle: TextStyle,
    textFieldBackgroundColor: Int = color.base_3,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false,
    isSingleLine: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    cursorColor: Int= color.useful_nums_text_color,
){

    var errorColor = colorResource(id = color.transparent)
    if (isError) errorColor = colorResource(id = color.danger_500)

    Column{
        TextField(
            modifier = modifier.border(
                width = 1.dp,
                color = errorColor,
                shape = RoundedCornerShape(4.dp)
            ),
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(4.dp),
            placeholder = placeholder
        )

        if (isError && errorMsg != ""){
            AppText(
                modifier = Modifier
                    .padding(top = 8.dp),
                fontStyle = FontStyle.BaseTextMediumBody3,
                text = errorMsg,
                color = errorColor
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    modifier: Modifier,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isSingleLine: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    cursorColor: Int= color.useful_nums_text_color,
    textFieldBackgroundColor: Int = color.base_3,
){
    var passwordIcon = remember {
        mutableStateOf(drawable.ic_trailing_hide)
    }

    var visualTransformationType = remember {
        mutableStateOf(visualTransformation)
    }

    var isPasswordVisible = remember {
        mutableStateOf(false)
    }

    Column{
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            trailingIcon = {
                if (visualTransformation == PasswordVisualTransformation()){
                    Icon(
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                if (isPasswordVisible.value) {
                                    isPasswordVisible.value = false
                                    passwordIcon.value = drawable.ic_trailing_hide
                                    visualTransformationType.value = PasswordVisualTransformation()
                                } else {
                                    isPasswordVisible.value = true
                                    passwordIcon.value = drawable.ic_trailing
                                    visualTransformationType.value = VisualTransformation.None
                                }
                            },
                        painter = painterResource(id = passwordIcon.value),
                        contentDescription = null,
                        tint = colorResource(id = color.white),
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            visualTransformation = visualTransformationType.value,
            textStyle = TextStyle(
                fontSize = 19.sp,
                lineHeight = 26.sp,
                fontFamily = stcForwardFamily,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(4.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldWithError(
    modifier: Modifier,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    value: String,
    errorMsg: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false,
    isSingleLine: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    cursorColor: Int= color.useful_nums_text_color,
    textFieldBackgroundColor: Int = color.base_3,
){
    var passwordIcon = remember {
        mutableStateOf(drawable.ic_trailing_hide)
    }

    var visualTransformationType = remember {
        mutableStateOf(visualTransformation)
    }

    var isPasswordVisible = remember {
        mutableStateOf(false)
    }

    var errorColor = colorResource(id = color.transparent)
    if (isError) errorColor = colorResource(id = color.danger_500)

    Column{
        TextField(
            modifier = modifier.border(
                width = 1.dp,
                color = errorColor,
                shape = RoundedCornerShape(4.dp)
            ),
            value = value,
            onValueChange = onValueChange,
            trailingIcon = {
                if (visualTransformation == PasswordVisualTransformation()){
                    Icon(
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                if (isPasswordVisible.value) {
                                    isPasswordVisible.value = false
                                    passwordIcon.value = drawable.ic_trailing_hide
                                    visualTransformationType.value = PasswordVisualTransformation()
                                } else {
                                    isPasswordVisible.value = true
                                    passwordIcon.value = drawable.ic_trailing
                                    visualTransformationType.value = VisualTransformation.None
                                }
                            },
                        painter = painterResource(id = passwordIcon.value),
                        contentDescription = null,
                        tint = colorResource(id = color.white),
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            visualTransformation = visualTransformationType.value,
            textStyle = TextStyle(
                fontSize = 19.sp,
                lineHeight = 26.sp,
                fontFamily = stcForwardFamily,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(4.dp)
        )

        if (isError){
            AppText(
                modifier = Modifier
                    .padding(top = 8.dp),
                fontStyle = FontStyle.BaseTextMediumBody3,
                text = errorMsg,
                color = errorColor
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldWithProgressBarWithError(
    modifier: Modifier,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    value: String,
    errorMsg: String,
    textStyle: TextStyle,
    progress: Float = 0f,
    progressBarColor: Color,
    trackColor: Color,
    progressHint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false,
    isSingleLine: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    cursorColor: Int= color.useful_nums_text_color,
    textFieldBackgroundColor: Int = color.base_3,
){
    var passwordIcon = remember {
        mutableStateOf(drawable.ic_trailing_hide)
    }

    var visualTransformationType = remember {
        mutableStateOf(visualTransformation)
    }

    var isPasswordVisible = remember {
        mutableStateOf(false)
    }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    var borderColor = colorResource(id = color.transparent)
    if (isError) borderColor = colorResource(id = color.danger_500) else borderColor

    Column{
        TextField(
            modifier = modifier.border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(4.dp)
            ),
            value = value,
            onValueChange = onValueChange,
            trailingIcon = {
                if (visualTransformation == PasswordVisualTransformation()){
                    Icon(
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                if (isPasswordVisible.value) {
                                    isPasswordVisible.value = false
                                    passwordIcon.value = drawable.ic_trailing_hide
                                    visualTransformationType.value = PasswordVisualTransformation()
                                } else {
                                    isPasswordVisible.value = true
                                    passwordIcon.value = drawable.ic_trailing
                                    visualTransformationType.value = VisualTransformation.None
                                }
                            },
                        painter = painterResource(id = passwordIcon.value),
                        contentDescription = null,
                        tint = colorResource(id = color.white),
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            visualTransformation = visualTransformationType.value,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(4.dp)
        )

        if (isError){
            AppText(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp),
                fontStyle = FontStyle.BaseTextMediumBody3,
                text = errorMsg,
                color = borderColor
            )
        }
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding( top = 12.dp),
            progress = animatedProgress,
            color = progressBarColor,
            trackColor = trackColor
        )
        AppText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp, end = 16.dp),
            fontStyle = FontStyle.BaseTextRegularBody3,
            text = progressHint,
            color = colorResource(id = color.white))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberTextField(
    modifier: Modifier,
    value: String,
    textStyle: TextStyle,
    keyboardType: KeyboardType = KeyboardType.Number,
    isSingleLine: Boolean = true,
    textFieldBackgroundColor: Int = color.base_3,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    cursorColor: Int= color.useful_nums_text_color,
){

    Column{
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            label = label,
            shape = RoundedCornerShape(4.dp),
            placeholder = placeholder
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberTextFieldWithTextFieldValue(
    modifier: Modifier,
    value: TextFieldValue,
    textStyle: TextStyle,
    keyboardType: KeyboardType = KeyboardType.Number,
    isSingleLine: Boolean = true,
    textFieldBackgroundColor: Int = color.base_3,
    label: @Composable (() -> Unit)? = null,
    onValueChange: (TextFieldValue) -> Unit,
    cursorColor: Int= color.useful_nums_text_color,
){

    Column{
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            label = label,
            shape = RoundedCornerShape(4.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPasswordTextField(
    modifier: Modifier,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isSingleLine: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    cursorColor: Int= color.useful_nums_text_color,
    textFieldBackgroundColor: Int = color.base_3,
){
    var passwordIcon = remember {
        mutableStateOf(drawable.ic_trailing_hide)
    }

    var visualTransformationType = remember {
        mutableStateOf(visualTransformation)
    }

    var isPasswordVisible = remember {
        mutableStateOf(false)
    }

    Column{
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            trailingIcon = {
                if (visualTransformation == PasswordVisualTransformation()){
                    Icon(
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                if (isPasswordVisible.value) {
                                    isPasswordVisible.value = false
                                    passwordIcon.value = drawable.ic_trailing_hide
                                    visualTransformationType.value = PasswordVisualTransformation()
                                } else {
                                    isPasswordVisible.value = true
                                    passwordIcon.value = drawable.ic_trailing
                                    visualTransformationType.value = VisualTransformation.None
                                }
                            },
                        painter = painterResource(id = passwordIcon.value),
                        contentDescription = null,
                        tint = colorResource(id = color.white),
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            visualTransformation = visualTransformationType.value,
            textStyle = TextStyle(
                fontSize = 11.sp,
                lineHeight = 16.sp,
                fontFamily = stcForwardFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(4.dp),
            placeholder = placeholder
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPasswordTextFieldWithError(
    modifier: Modifier,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isSingleLine: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    errorMsg: String,
    isError: Boolean = false,
    isArabic: Boolean = false,
    cursorColor: Int= color.useful_nums_text_color,
    textFieldBackgroundColor: Int = color.base_3,
){
    var passwordIcon = remember {
        mutableStateOf(drawable.ic_trailing_hide)
    }

    var visualTransformationType = remember {
        mutableStateOf(visualTransformation)
    }

    var isPasswordVisible = remember {
        mutableStateOf(false)
    }

    var errorColor = colorResource(id = color.transparent)
    if (isError) errorColor = colorResource(id = color.danger_500)

    Column{
        TextField(
            modifier = modifier.border(
                width = 1.dp,
                color = errorColor,
                shape = RoundedCornerShape(4.dp)
            ),
            value = value,
            onValueChange = onValueChange,
            trailingIcon = {
                if (visualTransformation == PasswordVisualTransformation()){
                    Icon(
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                if (isPasswordVisible.value) {
                                    isPasswordVisible.value = false
                                    passwordIcon.value = drawable.ic_trailing_hide
                                    visualTransformationType.value = PasswordVisualTransformation()
                                } else {
                                    isPasswordVisible.value = true
                                    passwordIcon.value = drawable.ic_trailing
                                    visualTransformationType.value = VisualTransformation.None
                                }
                            },
                        painter = painterResource(id = passwordIcon.value),
                        contentDescription = null,
                        tint = colorResource(id = color.white),
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = colorResource(id = textFieldBackgroundColor),
                unfocusedTextColor = colorResource(id = textFieldBackgroundColor),
                disabledTextColor = colorResource(id = color.white),
                focusedIndicatorColor =  colorResource(id = color.transparent),
                unfocusedIndicatorColor = colorResource(id = color.base_3),
                cursorColor = colorResource(id = cursorColor)
            ),
            singleLine = isSingleLine,
            visualTransformation = visualTransformationType.value,
            textStyle = TextStyle(
                fontSize = 11.sp,
                lineHeight = 16.sp,
                fontFamily = stcForwardFamily,
                fontWeight = FontWeight.Normal,
                textAlign = if (isArabic) TextAlign.Right  else TextAlign.Left,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(4.dp),
            placeholder = placeholder
        )

        if (isError && errorMsg != "") {
            AppText(
                modifier = Modifier
                    .padding(top = 8.dp),
                fontStyle = FontStyle.BaseTextMediumBody3,
                text = errorMsg,
                color = errorColor
            )
        }
    }
}