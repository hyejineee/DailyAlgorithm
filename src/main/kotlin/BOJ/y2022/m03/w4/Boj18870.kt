package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    val sorted = arr.sorted().toSet().toIntArray()

    arr.forEach {
        bw.write("${binarySearch(it, sorted)} ")
    }

    bw.flush()
    bw.close()
}

private fun binarySearch(target: Int, list: IntArray): Int? {
    var start = 0
    var end = list.size-1

    while (start <= end) {
        val mid = (start + end) / 2

        if (list[mid] == target) {
            return mid
        }

        if (list[mid] > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return null
}

