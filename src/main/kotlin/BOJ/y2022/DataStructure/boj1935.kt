package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.floor

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val ex = readLine()
    val nums = (1..n).map { readLine().toDouble() }

    val s = Stack<Double>()
    for (i in ex) {
        if (i.isLetter()) {
            s.push(nums[i.toInt() - 65])
        } else {
            val n1 = s.pop()
            val n2 = s.pop()
            val result = when (i) {
                '*' -> n2 * n1
                '+' -> n2 + n1
                '-' -> n2 - n1
                else -> n2 / n1
            }
            s.push(result)
        }
    }

    print("%.2f".format(s.pop()))
}
