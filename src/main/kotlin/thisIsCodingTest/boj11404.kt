package thisIsCodingTest

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val m = readLine().toInt()

    val dp = Array(n+1){ i-> IntArray(n+1){j-> if(i==j) 0 else 10000000} }

    repeat((0 until m).count()) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        dp[a][b] = min(dp[a][b], c)
    }

    for (k in 1..n){
        for (i in 1..n){
            for (j in 1..n){
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])
            }
        }
    }

    for(i in 1..n){
        for (j in 1..n){
            val c = if(dp[i][j] < 10000000) dp[i][j] else 0
            bw.write("$c ")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}
