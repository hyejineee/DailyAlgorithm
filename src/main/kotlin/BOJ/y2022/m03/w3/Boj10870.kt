package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    if(n == 0){
        println(0)
        return@with
    }

    val dp = IntArray(n + 1) { 0 }
    dp[0] = 0
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    println(dp[n])

}


private fun fibo(n:Int): Int {
    if(n==0) return 0
    if(n==1) return 1

    return fibo(n-1) + fibo(n-2)
}
