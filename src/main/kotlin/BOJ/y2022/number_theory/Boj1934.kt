package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        (0 until readLine().toInt()).forEach {
            val (n, m) = readLine().split(" ").map { it.toInt() }
            println((n * m) / gcd(n, m))
        }
    }
}

private fun gcd(n: Int, m: Int): Int = if (m == 0) n else gcd(m, n % m)

