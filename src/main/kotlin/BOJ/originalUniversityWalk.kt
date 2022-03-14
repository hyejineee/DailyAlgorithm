package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val d = readLine().toInt()

        var dp = longArrayOf(1,0,0,0,0,0,0,0)

        for(i in 1.. d){
            dp = next(dp)
        }

        println(dp[0])
    }
}

private fun next(state:LongArray): LongArray {
    val temp = LongArray(8){0}

    temp[0] = state[1] + state[2]
    temp[1] = state[0] + state[2] + state[3]
    temp[2] = state[0] + state[1] + state[3] + state[4]
    temp[3] = state[1] + state[2] + state[4] + state[5]
    temp[4] = state[5] + state[3] + state[2] + state[7]
    temp[5] = state[3] + state[4] + state[6]
    temp[6] = state[5] + state[7]
    temp[7] = state[4] + state[6]

    for(i in 0 until 8){
        temp[i] = temp[i] % 1000000007
    }
    return temp
}
