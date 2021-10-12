package Problems

fun sortInside(n: Int) = n.toString()
    .map {
        it.toString().toInt()
    }
    .sortedDescending()
    .joinToString("")
    .toInt()
