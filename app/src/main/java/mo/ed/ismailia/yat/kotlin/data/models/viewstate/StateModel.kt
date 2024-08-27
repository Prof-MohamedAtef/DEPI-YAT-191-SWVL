package mo.ed.ismailia.yat.kotlin.data.models.viewstate

import java.io.Serializable

data class StateModel(
    var viewState: ViewState = ViewState.LOADING,
    var message: String? = "",
    var title: String? = "",
    var reloadAction: (() -> Unit)? = null
):Serializable


enum class ViewState{
    LOADING,
    SUCCESS,
    FAILURE,
    ERROR
}
