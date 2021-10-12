package Programmers

fun triangularSnail(n: Int): IntArray {
    val result = MutableList((n downTo 1).sum()) { 0 }
    return result.toIntArray()
}
