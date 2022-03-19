package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val nums = readLine().split(" ").map { it.toInt() }

    val primes = sequence {
        var numbers = generateSequence(2) { it + 1 }
        while (true){
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1).filter { it % prime !=0 }
        }
    }

    println(primes.take(1000).count { it in nums })
}