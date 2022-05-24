package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stack = Stack<Int>()

    (1..n).forEach {
        readLine().split(" ").let {
            when (it[0]) {
                "push" -> {
                    val num = it[1].toInt()
                    stack.push(num)
                }
                "pop" -> {
                    if (stack.isEmpty()) {
                        println(-1)
                        return@let
                    }
                    val p = stack.pop()
                    println(p)
                }
                "size" -> {
                    println(stack.size)
                }
                "empty" -> {
                    if (stack.isEmpty()) println(1) else println(0)
                }
                "top" -> {
                    if (stack.isEmpty()) {
                        println(-1)
                        return@let
                    }
                    println(stack.peek())
                }
            }
        }
    }
}