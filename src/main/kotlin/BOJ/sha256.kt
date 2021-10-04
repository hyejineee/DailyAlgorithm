package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader
import java.security.MessageDigest


fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val s = readLine()
        println(sha256(s))
    }
}

fun sha256(s: String) =
    MessageDigest.getInstance("SHA-256")
        .apply {
            update(s.toByteArray())
        }
        .digest()
        .joinToString("") {
            "%02x".format(it)
        }