package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val OX = readLine().toCharArray()

    var score = 0
    var bonusScore = 0

    for( i in OX.indices){
        when(OX[i]){
            'X' ->{
                bonusScore = 0
            }
            'O'->{
                score += i + 1 + bonusScore
                bonusScore +=1
            }
        }
    }
    println(score)
}
