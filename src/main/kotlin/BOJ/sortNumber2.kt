package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val negativeArr = MutableList<Int?>(1000001) { null }
        val positiveArr = MutableList<Int?>(1000001) { null }


        for (i in 0 until readLine().toInt()) {
            val n = readLine().toInt()

            if (n < 0) {
                if (negativeArr[abs(n)] != null) continue
                negativeArr[abs(n)] = n
            } else {
                if (positiveArr[abs(n)] != null) continue
                positiveArr[abs(n)] = n
            }
        }


        val printed = negativeArr.reversed().plus(positiveArr).filterNotNull()

        printed.forEach {
            bw.write("$it\n")
        }

        bw.flush()
        bw.close()
    }
}