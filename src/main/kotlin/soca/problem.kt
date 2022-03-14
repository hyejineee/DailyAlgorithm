package soca

fun p1(rectangles: Array<IntArray>): Array<String> {

    //1개씩 내리기
    for (i in rectangles.indices) {
        val (x1, y1, x2, y2) = rectangles[i]
        val d = y1 - downDistance(rectangles, rectangles[i])
        rectangles[i] = intArrayOf(x1, y1 - d, x2, y2 - d)
    }

    //옆으로 밀기
    for (i in rectangles.indices) {
        val (x1, y1, x2, y2) = rectangles[i]
        val d = x1 - leftDistance(rectangles, rectangles[i])
        rectangles[i] = intArrayOf(x1 - d, y1, x2 - d, y2)
    }

    println(rectangles.map { it.joinToString(" ") })
    return rectangles.map { it.joinToString(" ") }.toTypedArray()
}

private fun leftDistance(blocks: Array<IntArray>, cs: IntArray): Int {
    val (x1, y1, x2, y2) = cs

    var max = 0
    for (b in blocks) {
        if (b.contentEquals(cs)) continue
        val (i1, j1, i2, j2) = b

        if (i2 <= x1 && ((y1 in j1..j2 && y2 in j1..j2) || j1 in y1 until y2 || j2 in y1 + 1..y2 )) {
            if (max < i2) {
                max = i2
            }
        }
    }
    return max
}

private fun downDistance(blocks: Array<IntArray>, cs: IntArray): Int {
    val (x1, y1, x2, y2) = cs

    var max = 0
    for (b in blocks) {
        if (b.contentEquals(cs)) continue
        val (i1, j1, i2, j2) = b

        if (j1 < y1 && ((x1 in i1..i2 && x2 in i1..i2)|| i1 in x1 until x2 || i2 in x1 + 1..x2 )) {
            if (max < j2) {
                max = j2
            }
        }
    }
    return max
}

fun p2(height: IntArray, width: IntArray): Long {

    val z = height.zip(width)
    val sorted = z.sortedWith(compareBy({it.first * it.second},{it.first})).reversed()

    val w:Long = arrayOf(sorted[0], sorted[1]).fold(0) { acc, pair -> acc + pair.second }
    val h:Long = arrayOf(sorted[0], sorted[1]).minByOrNull { it.first }?.first?.toLong() ?: -1

    println("w:$w, h:$h")

    return w*h
}