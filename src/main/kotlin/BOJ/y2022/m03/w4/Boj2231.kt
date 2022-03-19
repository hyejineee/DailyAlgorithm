package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    for (i in n/2 until n){
        val sum = i + i.toString().fold(0){acc, c -> acc + Character.getNumericValue(c) }
        if(sum == n){
            println(i)
            return@with
        }
    }
    println(0)
}

