package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val tc = readLine().toInt()

       (1..tc).forEach {
            val n = readLine().toInt()
            val candies = readLine().split(" ").map {
                var num = it.toInt()
                if(num %2 !=0) num +=1
                num
            }.toMutableList()

            var count =0

            while (!check(candies)){
                val minus = candies.map { it/2 }

                for(i in 1 until candies.size){
                    candies[i-1] -= minus[i-1]
                    candies[i] += minus[i-1]

                    if(i == candies.size-1){
                        candies[i] -= minus[i]
                        candies[0] += minus[i]
                    }
                }
                count++
            }
            println(count)
        }
    }
}

private fun check(candies : MutableList<Int>): Boolean {
    for(i in candies.indices){
        if(candies[i]%2 != 0){
            candies[i] +=1
        }
    }

    return candies.toSet().size == 1
}