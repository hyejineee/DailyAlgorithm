package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private lateinit var chars: List<Char>
private val result = mutableSetOf<String>()
val vowel = listOf('a', 'e', 'i', 'o', 'u')
var l = 0
var c =0

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        readLine().split(" ").map { it.toInt() }.let {
            l = it[0]
            c = it[1]
        }

        chars = readLine().split(" ").map { it.single() }.sorted()

        for (i in 0..c - l) {
            dfs(chars[i], i)
        }

        result.sorted().forEach {
            println(it)
        }

    }
}

private fun dfs(
    start: Char,
    index :Int
) {

    val needVisit = mutableSetOf<String>()
    needVisit.add("" + start)

    while (needVisit.isNotEmpty()) {
        val  word = needVisit.first().also { needVisit.remove(it) }

        if (word.length == l) {
            if (word.count { it in vowel } >= 1 && word.count { it !in vowel } >= 2) {
                result.add(word)
            }
        }

        for (nextChar in chars.subList(index+1, c)) {
            if ((word + nextChar).length <= l && nextChar !in word) {
                val newWord = (word + nextChar).toSortedSet().joinToString("")
                needVisit.add( newWord)
            }
        }
    }
}