package mo.ed.ismailia.yat.kotlin.compose.features.trips.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mo.ed.ismailia.yat.kotlin.data.repository.trips.TripsRepository

class TripsViewModelFactory(
    private val tripsRepository: TripsRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TripsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TripsViewModel(tripsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}