package todd

class Pencil {
    fun write(message: String): WriteResult {
        return WriteResult((message))
    }
}

class WriteResult(val message: String) {

    fun on(paper: Paper) {
        paper.append(message)
    }

}
