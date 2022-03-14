package Problems

fun sortByAge(members: Array<Array<String>>) = members
    .map {
        Pair(it[0].toInt(), it[1])
    }
    .sortedBy {
        it.first
    }
    .map {
        arrayOf(it.first.toString(), it.second)
    }
    .toTypedArray()
