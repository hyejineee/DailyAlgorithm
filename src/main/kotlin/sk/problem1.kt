package sk

import codility.oddOccurrencesInArray
import kotlin.math.cos

fun problem1(money: Int, costs: IntArray): Int {
    val ms = intArrayOf(1, 5, 10, 50, 100, 500).zip(costs).map { Triple(it.first, it.second, it.second - it.first) }
    val sorted = ms.sortedWith(compareBy({ it.second }, { it.first }))

    var remain = money
    var result = 0

    for (i in sorted.indices) {
        val count = (remain / sorted[i].first)
        result += count * sorted[i].second
        remain -= count * sorted[i].first

        println("result : $result, remain:$remain")
    }


    return result
}


fun problem2(n: Int, clockwise: Boolean): Array<IntArray> {


    var startIndex = 0
    val result = Array(n){IntArray(n){0} }

    for (i in n downTo 1 step 2) {
        val board = Array(i) { IntArray(i) { 0 } }
        for (r in 0..3) {
            for (j in 0 until i) {
                println("i:$i, cur:$startIndex, $j")
                board[0][j] = i
            }
            rotate90(board.toMutableList(), i)
        }

        println("result")
        
        println("===")
    }

    return arrayOf()
}

private fun rotate90(board: MutableList<IntArray>, n: Int) {
    val temp = MutableList(n) { IntArray(n) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            board[j][n - i - 1] = board[i][j]
        }
    }

    println("rotate")
    board.forEach { println(it.toList()) }
}