package oliveYong


data class Station(
    val x: Int,
    val y: Int,
    val r: Int
) {
    fun includeInCircle(coordinate: Pair<Int, Int>) =
        coordinate in listOf(Pair(x - r, y), Pair(x, y - r), Pair(x + r, y), Pair(x, y + r))
}

fun problem1(x: IntArray, y: IntArray, r: IntArray, v: IntArray): Int {

    val stations = List(x.size) {
        Station(
            x[it], y[it], r[it]
        )
    }

    val L = stations.minBy { it.x }.let { it?.x?.minus(it.r) ?: -1 }
    val R = stations.maxByOrNull { it.x }.let { it?.x?.plus(it.r) ?: -1 }
    val B = stations.minByOrNull { it.y }.let { it?.y?.minus(it.r) ?: -1 }
    val T = stations.maxByOrNull { it.y }.let { it?.y?.plus(it.r) ?: -1 }

    val converted = v.mapIndexed { index, item ->
        when (index % 2 == 0) {
            true -> convertX(L, item, R)
            else -> convertY(B, item, T)
        }
    }

    val coordinates = (converted.indices step 2).map {
        Pair(converted[it], converted[it + 1])
    }

    val count = coordinates.filter { coordinate ->
        coordinate.first in (L + 1) until R && coordinate.second in (B + 1) until T
                || stations.filter { it.includeInCircle(coordinate) }.isNotEmpty()
    }.count()


    return ((count.toDouble() / coordinates.size.toDouble()) * (R - L) * (T - B)).toInt()
}

fun convertX(i: Int, x: Int, r: Int) = i + x % (r - i)

fun convertY(b: Int, y: Int, t: Int) = b + y % (t - b)