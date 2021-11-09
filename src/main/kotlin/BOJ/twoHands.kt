package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (ml, mr, tl, tr) = readLine().split(" ")

        if (ml == mr && (RSP(ml, tl) || RSP(ml, tr))) {
            println("TK")
        } else if (tl == tr && (RSP(tl, mr) || RSP(tl, ml))) {
            println("MS")
        } else {
            println("?")
        }
    }
}

private fun RSP(n1: String, n2: String): Boolean {
    when (n1) {
        "S" -> {
            when (n2) {
                "S" -> {
                    return false
                }
                "R" -> {
                    return true
                }
                else -> {
                    return false
                }
            }
        }
        "R" -> {
            when (n2) {
                "S" -> {
                    return false
                }
                "R" -> {
                    return false
                }
                else -> {
                    return true
                }
            }
        }
        else -> {
            when (n2) {
                "S" -> {
                    return true
                }
                "R" -> {
                    return false
                }
                else -> {
                    return false
                }
            }
        }
    }
}