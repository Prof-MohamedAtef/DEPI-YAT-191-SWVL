package mo.ed.ismailia.yat.kotlin.data.exception

abstract class BaseException : RuntimeException {

    var serverErrorMessage = "" // This is used as a title in dialogs

    constructor(errorMessage: String?) : super(errorMessage)

    constructor(errorMessage: String?, serverErrorMessage: String?) : super(errorMessage) {
        if (serverErrorMessage != null) {
            this.serverErrorMessage = serverErrorMessage
        }
    }

    constructor(throwable: Throwable?) : super(throwable)

    constructor() : super()
}
