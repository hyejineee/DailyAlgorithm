package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    var num = n
    var i = 2
    while (num !=1){
        if(num % i ==0){
            println(i)
            num /=i
            continue
        }
        i++
    }
}

