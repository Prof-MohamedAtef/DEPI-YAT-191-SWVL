package mo.ed.ismailia.yat.kotlin.network

sealed class NetworkResultWrapper<out T> {
    object Loading : NetworkResultWrapper<Nothing>()
    data class Success<out T>(val data: T) : NetworkResultWrapper<T>()
    data class Error(val message: String) : NetworkResultWrapper<Nothing>()
    object Failure : NetworkResultWrapper<Nothing>()
}