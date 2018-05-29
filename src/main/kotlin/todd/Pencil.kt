package todd

class Pencil(var durability: Int) {

    fun write(message: String): WriteResult? {
        val result = WriteResult((message))
        if (durability > 0) {
            durability -= message.length;
            return result
        }
        return null
    }
}

class WriteResult(val message: String) {

    fun on(paper: Paper) {
        paper.append(message)
    }

}
