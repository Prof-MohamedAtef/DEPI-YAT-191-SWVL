package mo.ed.nozha.apps.compose.base.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BaseHorizontalShape(radius: Int, color: Color, width: Int, height: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .width(width.dp)
        .height(height.dp)
        .clip(
            RoundedCornerShape(
                topStart = radius.dp,
                topEnd = radius.dp,
                bottomStart = radius.dp,
                bottomEnd = radius.dp
            )
        )
        .background(color = color))
}

@Composable
@Preview
fun BaseHorizontalShape(){
    BaseHorizontalShape(6, Color.Magenta, 20, 20)
}

@Composable
fun BaseVerticalShape(radius: Int, color: Color, width: Int, height: Int) {
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(width.dp)
        .height(height.dp)
        .clip(
            RoundedCornerShape(
                topStart = radius.dp,
                topEnd = radius.dp,
                bottomStart = radius.dp,
                bottomEnd = radius.dp
            )
        )
        .background(color = color))
}

@Composable
@Preview
fun BaseVerticalShapePreview(){
    BaseVerticalShape(8, Color.Yellow, 25, 50)
}

@Composable
fun BaseBoxShape(radius: Int, color: Color, width: Int) {
    Box(modifier = Modifier
        .width(width.dp)
        .height(width.dp)
        .clip(
            RoundedCornerShape(
                topStart = radius.dp,
                topEnd = radius.dp,
                bottomStart = radius.dp,
                bottomEnd = radius.dp
            )
        )
        .background(color = color))
}

@Composable
@Preview
fun BaseBoxShapePreview(){
    BaseBoxShape(radius = 15, color = Color.Magenta, width = 130)
}

@Composable
@Preview
fun CircleShapePreview(){
    CircleShape(165, Color.Blue)
}

@Composable
@Preview
fun CircleShape(size: Int = 100, color: Color = Color.Black) {
    Canvas(modifier = Modifier.size(size.dp), onDraw = {
        val size = size.dp.toPx()
        drawCircle(
            color = color,
            radius = size / 2f
        )
    })
}