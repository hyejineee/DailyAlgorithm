package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.roundToInt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    val arr = (0 until n).map { readLine().toInt() }.sorted()

    println(arr.average().roundToInt())
    println(arr[arr.size/2])
    val g = arr.groupBy { it }
    val max = g.maxByOrNull { it.value.size }
    val filter = g.filter { it.value.size == max?.value?.size }.keys.toList()


    if(filter.size > 1){
        println(filter[1])
    }else{
        println(filter[0])
    }

    println(abs((arr.minOrNull()?:-1)- (arr.maxOrNull() ?: -1)))

    bw.flush()
    bw.close()
}

