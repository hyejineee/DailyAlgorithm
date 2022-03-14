package codility

import kotlin.math.abs
import kotlin.math.min

fun tapeEquilibrium(A: IntArray): Int {
    var front = 0
    var back = A.sum()

    var min = 1000000
    for (i in 1 until A.size) {
        println("f : $front, b : $back")
        front += A[i-1]
        back -= A[i-1]

        println("f : $front, b : $back, abs : ${abs(front - back)}")
        min = min(min, abs(front - back))
    }
    return min
}