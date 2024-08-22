package mo.ed.ismailia.yat.kotlin.compose.features.trips.view.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mo.ed.ismailia.yat.kotlin.compose.base.appbar.AppToolBar
import mo.ed.ismailia.yat.kotlin.compose.base.theme.AppTheme
import mo.ed.ismailia.yat.kotlin.compose.features.trips.viewmodel.TripsViewModel
import mo.ed.ismailia.yat.kotlin.network.NetworkResultWrapper

@Composable
fun tripsScreen(
    tripsViewModel: TripsViewModel = viewModel()
) {
    val tripsState by tripsViewModel.tripsState

    LaunchedEffect(Unit) {
        tripsViewModel.getTrips()
    }

    when (tripsState) {
        is NetworkResultWrapper.Loading -> LoadingScreen()
        is NetworkResultWrapper.Success -> ChooseTripScreen((tripsState as NetworkResultWrapper.Success).data)
        is NetworkResultWrapper.Failure -> FailureScreen()
        is NetworkResultWrapper.Error -> ErrorScreen((tripsState as NetworkResultWrapper.Error).message)
    }
    /*
    Observer pattern
     */
}

@Composable
fun LoadingScreen() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ErrorScreen(message: String) {
    Text(
        text = "Error: $message", modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun FailureScreen() {
    Text(
        text = "Failed to load data. Please check your connection.", modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}