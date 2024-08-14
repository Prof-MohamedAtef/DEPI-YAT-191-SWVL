package mo.ed.nozha.apps.compose.base

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import mo.ed.nozha.apps.R

val stcForwardBold = FontFamily(Font(R.font.stcforward_bold, FontWeight.Bold))

@Composable
fun BaseTextNumber1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 42.sp,
    fontFamily: FontFamily = stcForwardBold,
    lineHeight: TextUnit = 20.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Bold),
    maxLines: Int = 1,
    textAlign: TextAlign? = null,
    softWrap : Boolean
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        ),
    )
}
@Composable
fun BaseTextNumber2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 35.sp,
    fontFamily: FontFamily = stcForwardBold,
    lineHeight: TextUnit = 20.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Bold),
    maxLines: Int = 1,
    textAlign: TextAlign? = null,
    softWrap : Boolean
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        ),
    )
}

@Composable
fun BaseTextNumber3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 29.sp,
    fontFamily: FontFamily = stcForwardBold,
    lineHeight: TextUnit = 20.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Bold),
    maxLines: Int = 1,
    textAlign: TextAlign? = null,
    softWrap : Boolean
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        ),
    )
}
/*
//styleName: Light Theme/Android/Number/Number 4;
font-family: STC Forward;
font-size: 24px;
font-weight: 700;
line-height: 29px;
letter-spacing: 0em;
text-align: left;

 */

@Composable
fun BaseTextNumber4(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 24.sp,
    fontFamily: FontFamily = stcForwardBold,
    lineHeight: TextUnit = 20.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Bold),
    maxLines: Int = 1,
    textAlign: TextAlign? = null,
    softWrap : Boolean
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        softWrap = softWrap,
        textAlign = textAlign,
        overflow = overflow,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        ),
    )
}

@Composable
fun BaseTextNumber5(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 20.sp,
    fontFamily: FontFamily = stcForwardBold,
    lineHeight: TextUnit = 20.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Bold),
    maxLines: Int = 1,
    textAlign: TextAlign? = null,
    softWrap : Boolean
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        ),
    )
}

@Composable
fun BaseTextNumber6(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 17.sp,
    fontFamily: FontFamily = stcForwardBold,
    lineHeight: TextUnit = 20.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Bold),
    maxLines: Int = 1,
    textAlign: TextAlign? = null,
    softWrap : Boolean
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        softWrap = softWrap,
        overflow = overflow,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        ),
    )
}