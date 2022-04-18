package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }
        arr.drop(1).forEach {
            var count = 1
            while (true) {
                val rotate = arr.first() * count
                if (rotate % it == 0) {
                    println("${rotate / it}/$count")
                    break
                }
                count++
            }
        }
    }
}

