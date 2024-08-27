package mo.ed.ismailia.yat.kotlin.compose.features.trips.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import mo.ed.ismailia.yat.kotlin.compose.features.trips.viewmodel.TripsViewModel
import mo.ed.ismailia.yat.kotlin.data.models.viewstate.ViewState
import mo.ed.ismailia.yat.kotlin.network.NetworkResultWrapper

@Composable
fun tripsScreen(
    isConnected: Boolean,
    tripsViewModel: TripsViewModel = viewModel()
) {
    val tripsUiState =tripsViewModel.tripsUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        tripsViewModel.getTrips(isConnected)
    }

    when (tripsUiState.value.viewState) {
        ViewState.LOADING -> LoadingScreen()
        ViewState.SUCCESS -> ChooseTripScreen(tripsUiState.value.data)
        ViewState.FAILURE -> tripsUiState.value.errorMessage?.let { ErrorScreen(it) }

        else-> {

        }
    }
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