package mo.ed.ismailia.yat.kotlin.compose.features.trips.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mo.ed.ismailia.yat.kotlin.compose.base.appbar.AppToolBar
import mo.ed.ismailia.yat.kotlin.compose.base.theme.AppTheme
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
                AppToolBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White),
                    modifier = Modifier
                        .clickable {

                        }
                        .fillMaxWidth(),
                    title = "Choose Your Trip",
                    isShowOldBackArrow = true,
                    onBackPressed = onBackPress,
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
            .background(color = Color.Red)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            tripsData?.let {
                items(it.size) { data ->
                    TripCard(tripsData[data])
                }
            }
        }
    }
}
