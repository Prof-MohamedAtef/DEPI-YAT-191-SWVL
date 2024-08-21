package mo.ed.ismailia.yat.kotlin.compose.features.trips.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mo.ed.ismailia.yat.kotlin.compose.base.AppText
import mo.ed.ismailia.yat.kotlin.compose.base.FontStyle
import mo.ed.ismailia.yat.kotlin.data.response.trips.TripsResponseItem

@Composable
fun tripListItem(trip: TripsResponseItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(color = Color.White)
            .clip(RoundedCornerShape(size = 20.dp))
            .padding(all = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentWidth()
                ) {
                    AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = trip.time_from)
                    Spacer(modifier = Modifier.height(5.dp))
                    AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = trip.time_to)
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 5.dp, bottom = 5.dp)
                        .width(2.dp)
                        .background(Color.Gray)
                )
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentWidth()
                ) {
                    AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = "22 min")
                    Spacer(modifier = Modifier.height(5.dp))
                    AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = trip.from)
                    Spacer(modifier = Modifier.height(5.dp))
                    AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = trip.to)
                    Spacer(modifier = Modifier.height(5.dp))
                    AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = "15 min")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.wrapContentSize(),
                ) {
                    AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = "Premium")
                    AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = "Bus")
                    AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = "AC")
                }
                AppText(fontStyle = FontStyle.BaseTextMediumBody3, text = trip.price)
            }

        }
    }
}

@Preview
@Composable
fun tripListItemPreview() {
//    tripListItem(data)
}
