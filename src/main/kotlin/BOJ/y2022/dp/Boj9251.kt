package BOJ


import java.awt.SystemTray
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val arr1 = readLine().toCharArray().toMutableList().apply { add(0, '-') }
        val arr2 = readLine().toCharArray().toMutableList().apply { add(0,'-') }
        val dp = MutableList(arr1.size){
            MutableList(arr2.size){0}
        }

        for(i in 1 until arr1.size){
            for(j in 1 until arr2.size){
                if(arr1[i] == arr2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1
                }else{
                    dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1])
                }
            }
        }

        println(dp.flatten().maxOrNull()?:-1)
    }
}