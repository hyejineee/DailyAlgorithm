package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val baskets = mutableListOf<MutableList<Int>>()

        (1..3).forEach {
            val (capacity, amountOfMilk) = readLine().split(" ").map { it.toInt() }
            baskets.add(mutableListOf(capacity, amountOfMilk))
        }

        for (i in 0 until 100){
            val currentIndex = i %3
            val nextIndex = (i+1)%3
            pour(currentIndex, nextIndex, baskets)
        }
        baskets.forEach {
            println(it[1])
        }
    }
}

private fun pour(currentIndex:Int, nextIndex:Int, baskets:MutableList<MutableList<Int>>){
    val needAmount = baskets[nextIndex][0] - baskets[nextIndex][1]
    val amountOfPourMilk = if(baskets[currentIndex][1] >= needAmount) needAmount else baskets[currentIndex][1]

    baskets[currentIndex][1] -= amountOfPourMilk
    baskets[nextIndex][1] += amountOfPourMilk

}