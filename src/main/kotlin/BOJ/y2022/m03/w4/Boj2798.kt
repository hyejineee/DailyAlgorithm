package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }
    var max = 0
    for(i in arr.indices){
        for (j in i+1 until arr.size){
            for (k in j+1 until arr.size){
                val sum = arr[i] + arr[j] +arr[k]
               if(sum in (max + 1)..m){
                   max = sum
               }
            }
        }
    }

    println(max)
}

