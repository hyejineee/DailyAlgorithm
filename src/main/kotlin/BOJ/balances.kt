package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val ms = readLine().split(" ").map { it.toInt() }.sorted()

        var result = 0
        for (i in ms){
            if(i <= result +1){
                result +=i
            }else{
                break
            }
        }
        println(result + 1)
    }
}
