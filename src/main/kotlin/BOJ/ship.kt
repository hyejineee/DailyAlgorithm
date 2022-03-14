package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.system.exitProcess

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        readLine().toInt()
        val cranes = readLine().split(" ").map { it.toInt() }.sortedDescending()
        val boxCount = readLine().toInt()
        val box = LinkedList<Int>(readLine().split(" ").map { it.toInt() }.sortedDescending())

        if ((cranes.maxOrNull() ?: -1) < (box.maxOrNull() ?: -1)) {
            println(-1)
        }

        var minute = 0

        while (true) {

            if (box.isEmpty()) break

            for (i in cranes.indices) {
                if (box.isNotEmpty() && cranes[i] >= box.peek())
                    box.poll()
            }

            minute += 1
        }


        println(minute)

    }
}

