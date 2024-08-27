package mo.ed.ismailia.yat.kotlin.compose.features.trips.view.uistate

import mo.ed.ismailia.yat.kotlin.data.dto.TripsEntity
import mo.ed.ismailia.yat.kotlin.data.models.viewstate.ViewState

data class TripsUiState(
    var viewState: ViewState = ViewState.LOADING,
    val data: List<TripsEntity?>? = null,
    open val errorMessage: String? = null,
    open val isEmptyState: Boolean = false,
    open val hasError: Boolean? = null
)