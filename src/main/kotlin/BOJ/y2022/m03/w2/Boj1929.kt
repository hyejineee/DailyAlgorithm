package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (m, n) = readLine().split(" ").map { it.toInt() }

    val primes = BooleanArray(n + 1) { true }
    primes[0] = false
    primes[1] = false
    primes[2] = true

    for (i in 2..n) {
        if (primes[i].not()) continue
        for (j in 2 * i..n step i) primes[j] = false
    }

    (m..n).forEach { if (primes[it]) bw.write("$it\n") }

    bw.flush()
    bw.close()
}

