package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n,m) = readLine().split(" ").map { it.toInt() }
        val gcd = gcd(n,m)
        println(gcd)
        println((n*m)/gcd)
    }
}

private fun gcd(n1: Int, n2: Int): Int = if (n2 == 0) n1 else gcd(n2, n1 % n2)


