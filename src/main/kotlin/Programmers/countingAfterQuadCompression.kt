package Programmers

fun countingAfterQuadCompression(array: Array<IntArray>): IntArray {

    val result = mutableListOf(0, 0)
    quadCompression(
        array.map { it.toTypedArray() }.toTypedArray(),
        result
    )
    return result.toIntArray()
}


fun quadCompression(array: Array<Array<Int>>, result: MutableList<Int>) {

    val flatten = array.flatten()

    if (compressionCheckBy(flatten, 0)) {
        result[0] += 1
        return
    }

    if (compressionCheckBy(flatten, 1)) {
        result[1] += 1
        return
    }

    if (flatten.size == 4) {
        result[0] += flatten.count { it == 0 }
        result[1] += flatten.count { it == 1 }
        return
    }

    val length = array.size

    val quads = List(4) { k ->
        Array(length / 2) { i ->
            Array(length / 2) { j ->
                when (k) {
                    0 -> array[i][j]
                    1 -> array[i][j + length / 2]
                    2 -> array[i + length / 2][j]
                    else -> array[i + length / 2][j + length / 2]
                }
            }
        }
    }

    quads.forEach {
        quadCompression(it, result)
    }
    
}

fun compressionCheckBy(values: List<Int>, by: Int): Boolean = values.all { it == by }


