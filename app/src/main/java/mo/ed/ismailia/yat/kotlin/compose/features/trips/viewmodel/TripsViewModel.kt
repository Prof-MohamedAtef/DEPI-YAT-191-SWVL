package mo.ed.ismailia.yat.kotlin.compose.features.trips.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import mo.ed.ismailia.yat.kotlin.compose.features.trips.view.uistate.TripsUiState
import mo.ed.ismailia.yat.kotlin.data.Result
import mo.ed.ismailia.yat.kotlin.data.dto.TripsEntity
import mo.ed.ismailia.yat.kotlin.data.models.viewstate.ViewState
import mo.ed.ismailia.yat.kotlin.data.repository.trips.TripsRepository
import mo.ed.ismailia.yat.kotlin.data.response.trips.TripsResponse
import mo.ed.ismailia.yat.kotlin.network.NetworkResultWrapper

class TripsViewModel(private val tripsRepository: TripsRepository) : ViewModel() {


    private val _tripsUiState = MutableStateFlow(TripsUiState())
    val tripsUiState = _tripsUiState.asStateFlow()

    /*
    use trips repository
     */

    fun getTrips(isConnected: Boolean) {
        viewModelScope.launch {
            _tripsUiState.value = _tripsUiState.value.copy(
                viewState = ViewState.LOADING
            )
            tripsRepository.getTrips(isConnected).let { response ->
                when (response) {
                    is Result.Success ->{
                        _tripsUiState.value = _tripsUiState.value.copy(
                            viewState = ViewState.SUCCESS,
                            data = response.data as? List<TripsEntity?>?,
                            hasError = false
                        )
                    }
                    is Result.Failure ->{
                        _tripsUiState.value = _tripsUiState.value.copy(
                            viewState = ViewState.FAILURE,
                            data = null,
                            hasError = true,
                            errorMessage = response.exception?.message
                        )
                    }
                    else -> {

                    }
                }
            }

        }
    }

}