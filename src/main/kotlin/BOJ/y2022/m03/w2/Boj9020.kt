package BOJ

import Ds.prim
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val ts = readLine().toInt()
    for (t in 0 until ts) {
        val n = readLine().toInt()

        val primes = BooleanArray(n + 1) { true }
        primes[0] = false
        primes[1] = false

        for (i in 2..n) {
            if (primes[i].not()) continue
            for (j in i * 2..n step i) primes[j] = false
        }

        var gap = 1000000
        var n1 = 0
        var n2 = 0
        for (i in primes.indices) {
            if (primes[i].not()) continue

            if (primes[n - i]) {
                if(abs((n-i) - i) < gap){
                    gap = abs((n-i) - i)
                    n1 = i
                    n2 = (n-i)
                }
            }
        }
        bw.write("$n1 $n2\n")
        bw.flush()
    }
    bw.close()
}

