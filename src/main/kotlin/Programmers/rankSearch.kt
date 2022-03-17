package Programmers

fun rankSearch(info: Array<String>, query: Array<String>): IntArray {

    val infos = info.map { it.split(" ") }
    val qs = query.map { it.replace("and ", "").split(" ") }
    val counts = mutableListOf<Int>()
    for (i in qs) {
        val scoreFilter = infos.filter { it.last().toInt() >= i.last().toInt() }
        val lanFilter = if (i[0] != "-") scoreFilter.filter { it[0] == i[0] } else scoreFilter
        val positionFilter = if (i[1] != "-") lanFilter.filter { it[1] == i[1] } else lanFilter
        val expFilter = if (i[2] != "-") positionFilter.filter { it[2] == i[2] } else positionFilter
        val foodFilter = if (i[3] != "-") expFilter.filter { it[3] == i[3] } else expFilter

        println("condition : $i")
        println("filtering : $foodFilter")

        counts.add(foodFilter.size)

    }
    println(counts)
    return counts.toIntArray()
}
