package thisIsCodingTest

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val n = readLine().toInt()

        val scores = mutableListOf<Array<String>>()

        repeat(n){
            scores.add(readLine().split(" ").toTypedArray())
        }

        val sorted = scores.sortedWith(compareBy({-it[1].toInt()},{it[2].toInt()},{-it[3].toInt()},{it[0]}))

        sorted.forEach {
            println(it.toList())
        }
    }
}