package Problems

fun sortByCoordinate(coordinate: Array<Array<Int>>) = coordinate
    .sortedWith(
        compareBy({ it[0] }, { it[1] })
    )
    .toTypedArray()
