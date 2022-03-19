package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val infos = (1..n).map { readLine().split(" ").map { it.toInt() } }

    val rankings = infos.mapIndexed { index, list ->
        val (w,h) = list
        var count = 1
        for (i in infos.indices){
            val (targetW, targetH) = infos[i]

            if(w<targetW && h < targetH) count++
        }
        count
    }
    println(rankings.joinToString(" "))
}

