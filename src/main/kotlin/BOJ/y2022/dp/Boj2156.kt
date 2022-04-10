package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {

        val n = readLine().toInt()
        val arr = IntArray(n + 1) { 0 }
        val dp = IntArray(n + 1) { 0 }

        for (i in 1..n) {
            arr[i] = readLine().toInt()
        }

        if(n == 1){
            println(arr[1])
            System.exit(0)
        }

        if(n ==2){
            println(arr[1] + arr[2])
            System.exit(0)
        }

        dp[1] = arr[1]
        dp[2] = arr[2] + arr[1]

        for (i in 3..n) {
            dp[i] = maxOf(dp[i-1], dp[i-2]+arr[i], dp[i-3] + arr[i-1] + arr[i])
        }

        println(dp.last())
    }
}

