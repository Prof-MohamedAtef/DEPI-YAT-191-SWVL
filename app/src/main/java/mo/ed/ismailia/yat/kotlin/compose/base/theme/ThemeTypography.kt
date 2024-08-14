package mo.ed.nozha.apps.compose.base.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import mo.ed.nozha.apps.R

val stcForwardFamily = FontFamily(
    listOf(
        Font(R.font.stcforward_bold, FontWeight.Bold),
        Font(R.font.stcforward_light, FontWeight.Light),
        Font(R.font.stcforward_medium, FontWeight.Medium),
        Font(R.font.stcforward_regular, FontWeight.Normal),
    )
)

val typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    displayLarge = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    labelLarge = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    displayMedium = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    labelMedium = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = 16.sp
    ),
    displaySmall = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = 16.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    titleLarge = TextStyle(
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
)

val Typography.inputField : TextStyle
@Composable get() = TextStyle(
    fontSize = 19.sp,
    lineHeight = 26.sp,
    fontFamily = stcForwardFamily,
    fontWeight = FontWeight.Medium,
    textAlign = TextAlign.Center,
)

val Typography.leftAlignedInputField : TextStyle
    @Composable get() = TextStyle(
        fontSize = 12.sp,
        lineHeight = 26.sp,
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Start,
    )

val Typography.buttonSubLabel : TextStyle
    @Composable get() = TextStyle(
        fontSize = 11.sp,
        lineHeight = 16.sp,
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.W400,
    )

val Typography.smallDescription : TextStyle
    @Composable get() = TextStyle(
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontFamily = stcForwardFamily,
        fontWeight = FontWeight.W400,
    )