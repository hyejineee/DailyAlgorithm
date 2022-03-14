package BOJ

import Programmers.result
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()

        val bricks =  mutableListOf(mutableListOf(0,0,0,0))
        val dp = MutableList(n+1){0}

        (1 .. n).forEach { index ->
            val (width,h,weight) = readLine().split(" ").map { it.toInt() }
            bricks.add(mutableListOf(index, width,h, weight))
        }


        bricks.sortWith(compareBy{it[3]})


        for(i in 1..n ){
            val currentBrick = bricks[i]
            for(j in 0 until i){
                if(currentBrick[1] > bricks[j][1]){
                    dp[i] = maxOf(dp[i], dp[j] + currentBrick[2])
                }
            }
        }

        var max = dp.maxOrNull() ?:-1
        var index = n
        val result = mutableListOf<Int>()

        while(index !=0){
            if(max == dp[index]){
                result.add(bricks[index][0])
                max -= bricks[index][2]
            }
            index -=1
        }

        result.reverse()

        println(result.size)
        result.forEach {
            println(it)
        }
        bw.flush()
        bw.close()
    }
}