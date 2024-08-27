package mo.ed.ismailia.yat.kotlin.data.exception

class UnknownException : BaseException {

    override var message: String = ""

    constructor(textProvider: String) : super() {
        kotlin.runCatching {
            message = "Connection Error"
        }.onFailure {
            message = "Something went wrong, please try again later."
        }
    }

    constructor() : super() {
        kotlin.runCatching {
            message = "Connection Error"
        }.onFailure {
            message = "Something went wrong, please try again later."
        }
    }
}
