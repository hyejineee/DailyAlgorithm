package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import javax.xml.stream.events.Characters

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        val a = Array(n) {
            readLine().toCharArray().map { Character.getNumericValue(it).toByte() }.toByteArray()
        }

        val b = Array(n) {
            readLine().toCharArray().map { Character.getNumericValue(it).toByte() }.toByteArray()
        }

        var count = 0

        for (i in 0 until n - 2) {
            for (j in 0 until m - 2) {
                if (a[i][j] != b[i][j]) {
                    count ++
                    flip(i, j, a)
                }
            }
        }

        if(a.contentDeepEquals(b)){
            println(count)
        }else{
            println(-1)
        }
    }
}

private fun flip(i: Int, j: Int, a: Array<ByteArray>) {
    for (k in i..i + 2) {
        for (l in j..j + 2) {
            a[k][l] = if(a[k][l].toInt() == 0) 1 else 0
        }
    }
}