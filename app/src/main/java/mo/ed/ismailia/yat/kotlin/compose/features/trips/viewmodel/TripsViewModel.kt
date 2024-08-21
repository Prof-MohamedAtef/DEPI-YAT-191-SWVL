package mo.ed.ismailia.yat.kotlin.compose.features.trips.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mo.ed.ismailia.yat.kotlin.data.repository.trips.TripsRepository
import mo.ed.ismailia.yat.kotlin.data.response.trips.TripsResponse
import mo.ed.ismailia.yat.kotlin.network.NetworkResultWrapper

class TripsViewModel(private val tripsRepository: TripsRepository) : ViewModel() {
    /*
    use mutable state
     */

    private val _tripsState = mutableStateOf<NetworkResultWrapper<TripsResponse?>>(NetworkResultWrapper.Loading)
    val tripsState: State<NetworkResultWrapper<TripsResponse?>> = _tripsState

    /*
    use trips repository
     */

    fun getTrips() {
        // coroutine scope
        viewModelScope.launch {
            // suspend function
            tripsRepository.getTrips { response ->
                _tripsState.value = response
            }
        }
    }

}