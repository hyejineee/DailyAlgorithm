package Programmers

fun bestAlbum(genres: Array<String>, plays: IntArray): IntArray {

    val map = mutableMapOf<String, MutableList<IntArray>>()

    for (i in genres.indices) {
        val g = genres[i]
        val p = plays[i]
        map[g]?.add(intArrayOf(i, p)) ?: run { map[g] = mutableListOf(intArrayOf(i, p)) }
    }

    return genres.indices.groupBy { genres[it] }
        .toList()
        .sortedByDescending { it.second.sumBy { plays[it] } }
        .flatMap {
            it.second.sortedByDescending { plays[it] }.take(2)
        }.toIntArray()


//    return map.toSortedMap(Comparator { o1, o2 ->
//        (map[o2]?.sumBy { it[1] } ?: 0).compareTo((map[o1]?.sumBy { it[1] } ?: 0))
//    }).flatMap {
//        val songs = it.value.sortedByDescending { p -> p[1] }
//        if (songs.size > 1) songs.take(2) else songs.take(1)
//    }.map { it[0] }
//        .toIntArray()
}