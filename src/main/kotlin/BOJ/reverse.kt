package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import javax.xml.stream.events.Characters
import kotlin.math.max
import kotlin.math.min

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val s = readLine()

        var count1group = 0
        var count0group = 0
        var currentGroup = Character.getNumericValue(s.first())

        s.forEach {
            val currentNumber = Character.getNumericValue(it)

            if(currentNumber != currentGroup){
                when(currentGroup){
                    1 -> count1group++
                    else -> count0group++
                }
                currentGroup = currentNumber
            }
        }

        when (Character.getNumericValue(s.last())){
            1-> count1group++
            else ->count0group++
        }

        println(min(count0group, count1group))

    }
}