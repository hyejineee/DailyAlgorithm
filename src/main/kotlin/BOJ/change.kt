package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val changes = listOf(500,100,50,10,5,1)

        var change = 1000 - readLine().toInt()
        var count =0
        while (change > 0){
            when{
                change >=500 -> change -= 500
                change in 100 until 500 -> change -=100
                change in 50 until 100 -> change-=50
                change in 10 until 50 -> change-=10
                change in 5 until 10 -> change -= 5
                else -> change -=1
            }
            count ++
        }

        println(count)
    }
}

