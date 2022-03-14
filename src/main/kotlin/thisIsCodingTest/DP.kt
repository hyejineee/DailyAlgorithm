package thisIsCodingTest

import kotlin.math.max
import kotlin.math.min

class DP {
    fun make1(n: Int): Int {
        val dp = IntArray(30001) { 0 }
        for (i in 2..n) {
            dp[i] = dp[i - 1] + 1

            if (i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1)
            if (i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1)
            if (i % 5 == 0) dp[i] = min(dp[i], dp[i / 5] + 1)

        }
        return dp[n]
    }

    fun antWarrior(provision:IntArray):Int{
        val dp = IntArray(100){0}
        dp[0] = provision[0]
        dp[1] = maxOf(provision[0], provision[1])

        for(i in 2 until provision.size){
            dp[i] = max(dp[i-1],dp[i-2]+provision[i])
        }
        return dp[provision.size -1]
    }


}