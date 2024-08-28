package mo.ed.ismailia.yat.kotlin.compose.features.trips.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.compose.base.AppText
import mo.ed.ismailia.yat.kotlin.compose.base.FontStyle
import mo.ed.ismailia.yat.kotlin.compose.base.appbar.AppToolBar
import mo.ed.ismailia.yat.kotlin.compose.base.theme.AppIcons.OldBackArrowIcon
import mo.ed.ismailia.yat.kotlin.compose.base.theme.AppTheme
import mo.ed.ismailia.yat.kotlin.compose.base.theme.swvlBackground
import mo.ed.ismailia.yat.kotlin.compose.listener.BaseUiInterface
import mo.ed.ismailia.yat.kotlin.data.dto.TripsEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseTripScreen(
    tripsData: List<TripsEntity?>?,
    onBackPress: () -> Unit = {},
    tripUiInterface: BaseUiInterface.OnTripSelected? = null
) {
    AppTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        AppText(
                            fontStyle = FontStyle.BaseTextRegularBody1,
                            text = "Choose Your Trip"
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle navigation click */ }) {
                            Icon(
                                painter = painterResource(id = OldBackArrowIcon), // Replace with your drawable resource ID
                                contentDescription = "Navigation Icon",
                                tint = Color.Black // Set the color of the icon
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black
                    ),
                )
            },
            content = { paddingValues ->
                chooseTripBody(
                    tripsData,
                    paddingValues,
                    onTripSelected = tripUiInterface
                )
            }
        )
    }
}

@Composable
fun chooseTripBody(
    tripsData: List<TripsEntity?>?,
    paddingValues: PaddingValues,
    onTripSelected: BaseUiInterface.OnTripSelected?
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = swvlBackground)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 30.dp, bottom = 10.dp)
        ) {
            tripsData?.let {
                items(it.size) { data ->
                    tripsData[data]?.let { it1 ->
                        AppText(
                            modifier = Modifier.padding(top = 20.dp),
                            fontStyle = FontStyle.BaseTextMediumHeading3,
                            text = it1.availability
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    TripCard(tripsData[data])
                }
            }
        }
    }
}
