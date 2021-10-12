package Problems

fun bestSeller(n: Int, titles: Array<String>): String {
    val map = mutableMapOf<String, Int>()
    for (title in titles) {
        map[title] = map[title]?.plus(1) ?: 1
    }
    
    return map.toSortedMap().maxByOrNull { it.value }?.key ?: ""
}