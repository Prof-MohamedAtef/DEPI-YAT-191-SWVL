package mo.ed.ismailia.yat.kotlin.compose.features.trips.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mo.ed.ismailia.yat.kotlin.compose.base.AppText
import mo.ed.ismailia.yat.kotlin.compose.base.FontStyle
import mo.ed.ismailia.yat.kotlin.compose.base.theme.AppIcons
import mo.ed.ismailia.yat.kotlin.compose.base.theme.swvlGrayCardBorder
import mo.ed.ismailia.yat.kotlin.data.dto.TripsEntity
import mo.ed.ismailia.yat.kotlin.data.response.trips.TripsResponseItem

@Composable
fun TripCard(trip: TripsEntity?) {
    trip?.let {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AppText(
                                fontStyle = FontStyle.BaseTextLightBody2,
                                text = trip.departure,
                                modifier = Modifier.padding(top = 8.dp, end = 8.dp, bottom = 5.dp)
                            )

                            AppText(
                                fontStyle = FontStyle.BaseTextLightBody2,
                                text = trip.arrival,
                                modifier = Modifier.padding(top = 8.dp, end = 8.dp, bottom = 5.dp)
                            )

                        }
                        Divider(
                            color = Color.Gray,
                            modifier = Modifier
                                .width(1.5.dp)
                                .height(80.dp)
                        )
                        Row {
                            Column(modifier = Modifier.padding(start = 12.dp)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(id = AppIcons.walkingPerson),
                                        tint = Color.LightGray,
                                        contentDescription = "Running Icon",
                                        modifier = Modifier.size(18.dp)
                                    )
                                    AppText(
                                        fontStyle = FontStyle.BaseTextLightBody2,
                                        text = trip.time_from,
                                        modifier = Modifier.padding(top = 8.dp, end = 8.dp, bottom = 5.dp),
                                    )
                                }
                                AppText(
                                    fontStyle = FontStyle.BaseTextLightBody2,
                                    text = trip.from,
                                    modifier = Modifier.padding(top = 8.dp, end = 8.dp, bottom = 5.dp),
                                )
                                AppText(
                                    fontStyle = FontStyle.BaseTextLightBody2,
                                    text = trip.to,
                                    modifier = Modifier.padding(top = 8.dp, end = 8.dp, bottom = 5.dp),
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(id = AppIcons.walkingPerson),
                                        tint = Color.LightGray,
                                        contentDescription = "Running Icon",
                                        modifier = Modifier.size(18.dp)
                                    )
                                    AppText(
                                        fontStyle = FontStyle.BaseTextLightBody2,
                                        text = trip.time_to,
                                        modifier = Modifier.padding(top = 8.dp, end = 8.dp, bottom = 5.dp),
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(top = 7.dp))
                    Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().background(color = swvlGrayCardBorder))
                    Spacer(modifier = Modifier.padding(top = 7.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(20.dp))
                                .wrapContentHeight()
                                .background(Color.Black.copy(alpha = 0.05f)),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier.padding(6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                AppText(
                                    fontStyle = FontStyle.BaseTextLightBody3,
                                    text = "Premium ",
                                    color = Color.Green,
                                    modifier = Modifier.padding(start = 5.dp)
                                )
                                AppText(
                                    fontStyle = FontStyle.BaseTextLightBody3,
                                    text = "* Bus",
                                    color = Color.Gray,
                                    modifier = Modifier.padding(start = 5.dp)
                                )
                                AppText(
                                    fontStyle = FontStyle.BaseTextLightBody3,
                                    text = "* AC",
                                    color = Color.Gray,
                                    modifier = Modifier.padding(end = 5.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(100.dp))
                        Row {
                            AppText(
                                fontStyle = FontStyle.BaseTextLightBody3,
                                text = trip.price,
                                color = Color.Green,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTripScreen() {
//    TripScreen(onBackPressed = {})
}


