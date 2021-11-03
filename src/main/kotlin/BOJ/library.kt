package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n,m) = readLine().split(" ").map { it.toInt() }
        val bookPositions = readLine().split(" ").map { it.toInt() }

        val largest = bookPositions.maxOf { abs(it) }

        val positives = TreeSet<Int>(reverseOrder())
        val negative =  TreeSet<Int>()

        positives.addAll(bookPositions.filter { it > 0 })
        negative.addAll(bookPositions.filter { it < 0 })

        var footCount = 0
        while (positives.isNotEmpty()){
            for(i in 0 until m){
                if(positives.isEmpty()) break
                val pop = positives.pollFirst()
                if( i == 0) footCount +=pop
            }
        }

        while (negative.isNotEmpty()){
            for(i in 0 until m){
                if(negative.isEmpty()) break
                val pop = negative.pollFirst()
                if( i == 0) footCount += abs(pop)
            }
        }

        println(footCount*2 - largest)




    }
}