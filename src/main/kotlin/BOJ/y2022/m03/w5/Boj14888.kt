package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

var max = -1000000001
var min = 1000000001
fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {

        val n = readLine().toInt()
        val nums = readLine().split(" ").map { it.toInt() }.toIntArray()
        val counts = readLine().split(" ").map { it.toInt() }.toIntArray()

        dfs(1, nums[0], n, counts, nums)

        println(max)
        println(min)
    }
}


private fun dfs(level: Int, result: Int, n: Int, counts: IntArray, nums: IntArray) {
    if (level == n) {
        max = max(max, result)
        min = min(min, result)
        return
    }

    if (counts[0] > 0) {
        counts[0] = counts[0] - 1
        dfs(level + 1, result + nums[level], n, counts, nums)
        counts[0] = counts[0] + 1
    }

    if (counts[1] > 0) {
        counts[1] = counts[1] - 1
        dfs(level + 1, result - nums[level], n, counts, nums)
        counts[1] = counts[1] + 1

    }

    if (counts[2] > 0) {
        counts[2] = counts[2] - 1
        dfs(level + 1, result * nums[level], n, counts, nums)
        counts[2] = counts[2] + 1
    }

    if (counts[3] > 0) {
        counts[3] = counts[3] - 1
        dfs(level + 1, result / nums[level], n, counts, nums)
        counts[3] = counts[3] + 1
    }
}
