package mo.ed.nozha.apps.compose.base

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import mo.ed.nozha.apps.compose.base.theme.stcForwardFamily


@Composable
fun BaseTextLightHeading1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Light,
    fontSize: TextUnit = 30.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 44.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Light),
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
fun BaseTextRegularHeading1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 30.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 44.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Normal),
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
fun BaseTextMediumHeading1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Medium,
    fontSize: TextUnit = 30.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 44.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Medium),
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
fun BaseTextBoldHeading1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 30.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 44.sp,
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
fun BaseTextLightHeading2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Light,
    fontSize: TextUnit = 21.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 32.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Light),
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
fun BaseTextRegularHeading2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 21.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 32.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Normal),
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
fun BaseTextMediumHeading2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Medium,
    fontSize: TextUnit = 21.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 32.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Medium),
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
fun BaseTextBoldHeading2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 21.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 32.sp,
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
fun BaseTextLightHeading3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Light,
    fontSize: TextUnit = 19.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 26.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Light),
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
fun BaseTextRegularHeading3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 19.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 26.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Normal),
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
fun BaseTextMediumHeading3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Medium,
    fontSize: TextUnit = 19.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 26.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle(fontWeight = FontWeight.Medium),
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
fun BaseTextBoldHeading3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 19.sp,
    fontFamily: FontFamily = stcForwardFamily,
    lineHeight: TextUnit = 26.sp,
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