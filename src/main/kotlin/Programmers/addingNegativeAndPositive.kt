package Programmers

fun addingNegativeAndPositive(absolutes: IntArray, signs: BooleanArray): Int = absolutes.foldIndexed(0){ index, acc, i ->
    acc + if(signs[index]) i else -i
}