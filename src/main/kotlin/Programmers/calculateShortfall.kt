package Programmers

fun calculateInsufficientAmount(price: Int, money: Int, count: Int): Long =
    (1..count).fold(0L) { acc, it -> acc + (price * it) }.let { if (money > it) 0L else it - money }
