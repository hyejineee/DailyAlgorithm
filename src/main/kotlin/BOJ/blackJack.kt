package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.acmicpc.net/problem/2798


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val cards = readLine().split(" ").map { it.toInt() }.toIntArray()

        println(blackJack(cards, m))
    }
}

fun blackJack(cards: IntArray, m: Int): Int {
    var max = 0
    for (i in cards.indices) {
        for (j in i + 1 until cards.size) {
            for (k in j + 1 until cards.size) {
                val v = cards[i] + cards[j] + cards[k]
                if (v in (max + 1)..m) {
                    max = v
                }
            }
        }
    }
    return max
}