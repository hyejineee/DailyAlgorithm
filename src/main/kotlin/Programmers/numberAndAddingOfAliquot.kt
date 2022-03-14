package Programmers

import kotlin.math.sqrt

fun numberAndAddingOfAliquot(left: Int, right: Int): Int = (left..right).fold(0) { acc, i ->
    if ((1..i).count{ i%it ==0 } % 2 == 0) {
        acc + i
    } else {
        acc - i
    }
}