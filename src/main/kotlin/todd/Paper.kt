package todd

class Paper {
    var message: String = ""

    fun append(message: String) {
        this.message = this.message + message
    }
}