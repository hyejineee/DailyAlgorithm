package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val testCase = readLine().toInt()

        for (i in 0 until testCase) {
            val s = readLine()
            println(keyLogger(s))
        }
    }
}

fun keyLogger(s: String): String {

    val left = Stack<Char>()
    val right = Stack<Char>()

    for (c in s) {
        when (c) {
            '-' -> {
                if (left.isEmpty()) continue
                left.pop()
            }
            '<' -> {
                if (left.isEmpty()) continue
                right.push(left.pop())
            }
            '>' -> {
                if (right.isEmpty()) continue
                left.push(right.pop())
            }
            else -> {
                left.push(c)
            }
        }
    }

    return left.joinToString("").plus(right.reversed().joinToString(""))
}