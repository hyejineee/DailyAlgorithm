package Programmers

fun rotateMatrixBorders(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
    val origin = Array(rows) { i ->
        IntArray(columns) { j ->
            i * columns + (j + 1)
        }
    }

    val result = mutableListOf<Int>()

    queries.forEach { (x1, y1, x2, y2) ->
        val sub = getSubMatrix(x1, y1, x2, y2, origin)
        val (rotated, min) = rotateBorder(sub, x2 - x1 + 1, y2 - y1 + 1)

        var x = 0
        var y = 0

        for (i in (x1 - 1)..(x2 - 1)) {
            for (j in (y1 - 1)..(y2 - 1)) {
                origin[i][j] = rotated[x][y]
                y++
            }
            x++
            y = 0
        }

        result.add(min)
    }

    return result.toIntArray()
}

fun getSubMatrix(x1: Int, y1: Int, x2: Int, y2: Int, origin: Array<IntArray>): Array<IntArray> {
    val sub = Array(x2 - x1 + 1) {
        IntArray(y2 - y1 + 1)
    }
    var x = 0
    var y = 0

    for (i in (x1 - 1)..(x2 - 1)) {
        for (j in (y1 - 1)..(y2 - 1)) {
            sub[x][y] = origin[i][j]
            y++
        }
        x++
        y = 0
    }
    return sub
}

fun rotateBorder(sub: Array<IntArray>, rows: Int, columns: Int): Pair<Array<IntArray>,Int>{
    var rotated = sub.copyOf()
    var subCopy = sub.copyOf()
    var swaped = intArrayOf(0)

    var min = sub.flatMap { it.asList() }.maxOrNull()?:0

    for (i in 0..3) {
        swaped = swap(subCopy.first(), swaped.last())
        min = minOf(min, subCopy.first().minOrNull()?:0)

        rotated[0] = swaped
        rotated = rotateMatrixToLeft(rotated, rotated.size, rotated.first().size)
        subCopy = rotateMatrixToLeft(subCopy, subCopy.size, subCopy.first().size)
    }

    return Pair(rotated, min)
}

private fun swap(origin: IntArray, first: Int): IntArray {
    val new = IntArray(origin.size)
    for (i in 1 until origin.size) {
        new[i] = origin[i - 1]
    }
    new[0] = first
    return new
}
