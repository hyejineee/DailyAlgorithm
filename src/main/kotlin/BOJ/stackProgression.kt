package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// https://www.acmicpc.net/problem/1874


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val c = readLine().toInt()

        val p = (0 until c).map {
            readLine().toInt()
        }.toIntArray()

        stackProgression(p).map {
            println(it)
        }
    }
}

fun stackProgression(p: IntArray): MutableList<String> {

    val pCopy = p.toMutableList()
    val r = mutableListOf<String>()
    val s = Stack<Int>()
    var i = 1

    while (pCopy.isNotEmpty()) {


        while (i <= pCopy.first()) {
            s.push(i)
            i++
            r.add("+")
        }


        if (s.peek() == pCopy.first()) {
            s.pop()
            r.add("-")
            pCopy.removeAt(0)
        } else {
            return mutableListOf("NO")
        }
    }

    return r
}