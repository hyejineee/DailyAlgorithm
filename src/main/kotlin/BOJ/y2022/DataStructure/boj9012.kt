package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    (1..n).forEach {
        val ps = readLine()
        if (isVPS(ps)) println("YES") else println("NO")
    }
}

private fun isVPS(ps: String): Boolean {
    val stack = Stack<Char>()

    ps.forEach {
        when(it){
            '('-> {stack.push(it)}
            ')' -> {
                if (stack.isEmpty()) return false
                stack.pop()
            }
        }
    }
    return stack.isEmpty()
}