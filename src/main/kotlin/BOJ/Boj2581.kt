package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val m = readLine().toInt()
    val n = readLine().toInt()

    val primes = (m..n).filter { it.isPrime() }
    if(primes.isEmpty()){
        println(-1)
        return@with
    }
    println(primes.sum())
    println(primes.minOrNull() ?:-1)

}

fun Int.isPrime():Boolean{
    if(this == 1) return false

    var i =2
    while (i*i <= this){
        if(this %i == 0)return false
        i++
    }

    return true
}