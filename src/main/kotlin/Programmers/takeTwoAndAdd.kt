package Programmers

fun takeTwoAndAdd(numbers: IntArray): IntArray =
    numbers.foldIndexed(mutableSetOf<Int>()) { index, acc, i ->
        for (j in index + 1 until numbers.size) {
            acc.add(i + numbers[j])
        }
        acc
    }.sorted().toIntArray()
