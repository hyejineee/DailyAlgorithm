package Problems

fun findNumber(ns: IntArray, ms: IntArray): IntArray = ms.map {
    if (it in ns) {
        1
    } else {
        0
    }
}.toIntArray()

