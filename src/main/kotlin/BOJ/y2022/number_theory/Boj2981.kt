package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt


fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val arr = (0 until readLine().toInt()).map { readLine().toInt() }.toIntArray().sorted()

        val ds = (arr.last() - arr.first()).aliquot()

        for (i in ds){
            val m = arr.first() % i
            if(arr.all { it %i == m }){
                print("$i ")
            }
        }
    }
}

private fun Int.aliquot(): List<Int> {
    val result = mutableSetOf<Int>()
    result.add(this)
    for (i in 2 ..sqrt(this.toDouble()).toInt()){
        if(this % i ==0){
            result.add(i)
            result.add(this/i)
        }
    }
    return result.sorted()
}


