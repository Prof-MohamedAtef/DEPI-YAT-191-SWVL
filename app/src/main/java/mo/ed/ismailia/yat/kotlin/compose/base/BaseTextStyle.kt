package mo.ed.ismailia.yat.kotlin.compose.base

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import mo.ed.ismailia.yat.kotlin.compose.base.theme.stcForwardFamily

fun getTextStyle(fontStyle: FontStyle, textAlign: TextAlign): TextStyle {

    return when (fontStyle) {
        FontStyle.BaseTextLightBody1 -> TextStyle(fontSize = 15.sp, lineHeight = 20.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Light, textAlign = textAlign)
        FontStyle.BaseTextLightBody2 -> TextStyle(fontSize = 13.sp, lineHeight = 18.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Light, textAlign = textAlign)
        FontStyle.BaseTextLightBody3 -> TextStyle(fontSize = 11.sp, lineHeight = 16.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Light, textAlign = textAlign)
        FontStyle.BaseTextRegularBody1 -> TextStyle(fontSize = 15.sp, lineHeight = 20.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Normal, textAlign = textAlign)
        FontStyle.BaseTextRegularBody2 -> TextStyle(fontSize = 13.sp, lineHeight = 18.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Normal, textAlign = textAlign)
        FontStyle.BaseTextRegularBody3 -> TextStyle(fontSize = 11.sp, lineHeight = 16.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Normal, textAlign = textAlign)
        FontStyle.BaseTextMediumBody1 -> TextStyle(fontSize = 15.sp, lineHeight = 20.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Medium, textAlign = textAlign)
        FontStyle.BaseTextMediumBody2 -> TextStyle(fontSize = 13.sp, lineHeight = 18.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Medium, textAlign = textAlign)
        FontStyle.BaseTextMediumBody3 -> TextStyle(fontSize = 11.sp, lineHeight = 16.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Medium, textAlign = textAlign)
        FontStyle.BaseTextBoldBody1 -> TextStyle(fontSize = 15.sp, lineHeight = 20.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextBoldBody2 -> TextStyle(fontSize = 13.sp, lineHeight = 18.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextBoldBody3 -> TextStyle(fontSize = 11.sp, lineHeight = 16.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextLightBody4 -> TextStyle(fontSize = 8.sp, lineHeight = 12.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Light, textAlign = textAlign)
        FontStyle.BaseTextLightHeading1 -> TextStyle(fontSize = 30.sp, lineHeight = 44.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Light, textAlign = textAlign)
        FontStyle.BaseTextLightHeading2 -> TextStyle(fontSize = 21.sp, lineHeight = 32.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Light, textAlign = textAlign)
        FontStyle.BaseTextLightHeading3 -> TextStyle(fontSize = 19.sp, lineHeight = 26.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Light, textAlign = textAlign)
        FontStyle.BaseTextRegularHeading1 -> TextStyle(fontSize = 30.sp, lineHeight = 44.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Normal, textAlign = textAlign)
        FontStyle.BaseTextRegularHeading2 -> TextStyle(fontSize = 21.sp, lineHeight = 32.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Normal, textAlign = textAlign)
        FontStyle.BaseTextRegularHeading3 -> TextStyle(fontSize = 19.sp, lineHeight = 26.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Normal, textAlign = textAlign)
        FontStyle.BaseTextMediumHeading1 -> TextStyle(fontSize = 30.sp, lineHeight = 44.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Medium, textAlign = textAlign)
        FontStyle.BaseTextMediumHeading2 -> TextStyle(fontSize = 21.sp, lineHeight = 32.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Medium, textAlign = textAlign)
        FontStyle.BaseTextMediumHeading3 -> TextStyle(fontSize = 19.sp, lineHeight = 26.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Medium, textAlign = textAlign)
        FontStyle.BaseTextBoldHeading3 -> TextStyle(fontSize = 30.sp, lineHeight = 44.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextBoldHeading1 -> TextStyle(fontSize = 21.sp, lineHeight = 32.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextBoldHeading2 -> TextStyle(fontSize = 19.sp, lineHeight = 26.sp, fontFamily = stcForwardFamily, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextNumber1 -> TextStyle(fontSize = 42.sp, lineHeight = 20.sp, fontFamily = stcForwardBold, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextNumber2 -> TextStyle(fontSize = 35.sp, lineHeight = 20.sp, fontFamily = stcForwardBold, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextNumber3 -> TextStyle(fontSize = 29.sp, lineHeight = 20.sp, fontFamily = stcForwardBold, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextNumber4 -> TextStyle(fontSize = 24.sp, lineHeight = 20.sp, fontFamily = stcForwardBold, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextNumber5 -> TextStyle(fontSize = 20.sp, lineHeight = 20.sp, fontFamily = stcForwardBold, fontWeight = FontWeight.Bold, textAlign = textAlign)
        FontStyle.BaseTextNumber6 -> TextStyle(fontSize = 17.sp, lineHeight = 20.sp, fontFamily = stcForwardBold, fontWeight = FontWeight.Bold, textAlign = textAlign)
    }
}
