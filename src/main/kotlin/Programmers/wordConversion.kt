package Programmers


fun wordConversion(begin: String, target: String, words: Array<String>): Int {

    if(target !in words) return 0

    val result = mutableListOf<List<String>>()
    dfs(begin, mutableListOf(), words, target, result)

    return result.minBy { it.size }?.size ?: 0
}

private fun dfs(
    start: String,
    visited: MutableList<String>,
    words: Array<String>,
    target: String,
    result: MutableList<List<String>>
) {

    if (start == target) {
        result.add(visited.toList())
        return
    }

    for (i in words.indices) {
        if (checkAvailable(start, words[i]) && words[i] !in visited) {
            visited.add(words[i])
            dfs(words[i], visited, words, target, result)
            visited.removeAt(visited.size - 1)
        }
    }
}

private fun checkAvailable(start: String, next: String): Boolean = BooleanArray(start.length) { start[it] == next[it] }.count { it } == start.length - 1



