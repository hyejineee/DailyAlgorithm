package Programmers

import java.util.*

fun tuple(s: String): IntArray = s
    .drop(2)
    .dropLast(2)
    .split("},{")
    .map {
        it.split(",").map { c -> c.toInt() }
    }
    .sortedBy { it.size }
    .flatMap { it.toList() }
    .toSet()
    .toIntArray()
