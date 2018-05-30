package todd

class Pencil(var durability: Int) {

    fun write(message: String): WriteResult? {
        var messageToWrite = ""
        for (char in message) {
            if(durability == 0) {
                messageToWrite += ' ';
            } else {
                messageToWrite += char
                if (!char.isWhitespace()) {
                    --durability
                    if (char.isUpperCase()) {
                        --durability
                    }
                }
            }
        }
        if (messageToWrite.length > 0) {
            return WriteResult((messageToWrite))
        }
        return null
    }
}

class WriteResult(val message: String) {

    fun on(paper: Paper) {
        paper.append(message)
    }

}
