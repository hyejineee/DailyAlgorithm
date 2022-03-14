package BOJ

import Ds.prim
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val n = readLine().toInt()

        if (n == 0) break

        val primes = BooleanArray(2*n +1){true}
        primes[0] = false
        primes[1] = false

        for(i in 2..2*n){
            if(primes[i].not()) continue
            for (j in i*2 ..2*n step i) primes[j] = false
        }

        var count =0
        (n+1 .. 2*n).forEach {
            if(primes[it]) count++
        }

        bw.write("$count\n")
        bw.flush()
    }
    bw.close()
}

