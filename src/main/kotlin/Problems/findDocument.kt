package Problems

fun findDocument(doc: String, word: String): Int {
    var docArray = doc.toCharArray()
    val wordArray = word.toCharArray()

    var count = 0


    while (docArray.size >= wordArray.size) {
        if (matches(docArray, wordArray)) {
            docArray = docArray.drop(word.length).toCharArray()
            count++
        } else {
            docArray = docArray.drop(1).toCharArray()
        }
    }

    return count
}

fun matches(docArray: CharArray, wordArray: CharArray): Boolean {
    for (i in wordArray.indices) {
        if (docArray[i] != wordArray[i]) {
            return false
        }
    }
    return true
}