package Programmers

var count = 1
var isFind = false
var result = 0

fun weekly5(word: String): Int {
    
    val words = listOf('A', 'E', 'I', 'O', 'U')

    for (i in words) {
        if (isFind) break
        preOrder(1, i.toString(), word, words.toCharArray())
        count++
    }

    return result
}

fun preOrder(currentLevel: Int, word: String, targetWord: String, words: CharArray) {

    if (word == targetWord) {
        isFind = true
        result = count
        return
    }

    if (currentLevel == words.size) {
        return
    }

    words.forEach {
        count++
        preOrder(currentLevel + 1, word.plus(it), targetWord, words)
    }
}