package Programmers

fun innerProduct(a: IntArray, b: IntArray): Int = a.foldIndexed(0){index, acc, i ->
    acc + (i * b[index])
}