package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val dices = readLine().split(" ").map { it.toInt() }

        val result = when {
            dices.toSet().size == 1 -> {
                // 같은 눈 3개 나온는 경우
                10000 + (dices.first() * 1000)
            }

            dices.toSet().size == 2 -> {
                // 같은 눈 2개만 나오는 경우
                val nun = dices.groupBy { it }.filter { it.value.size ==2 }.keys.first()
                1000 + (nun * 100)

            }
            else -> {
                // 모두 다른 눈이 나오는 경우
                (dices.maxOrNull()?:0) * 100
            }
        }

        println(result)
    }
}