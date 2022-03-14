package Programmers

fun menuRenewal(orders: Array<String>, course: IntArray): Array<String> {

    val courseMap = mutableMapOf<String, Int>()
    val combinations = mutableSetOf<String>()

    course.forEach { c ->
        orders.forEach {
            combination(it.toList().sorted(), combinations, c, "", 0)
        }
    }

    orders.forEach { order ->
        for (comb in combinations) {
            if (order.length < comb.length) continue
            if (comb.all { it in order }) {
                courseMap[comb] = courseMap[comb]?.plus(1) ?: 1
            }
        }
    }

    val group = mutableMapOf<Int, MutableList<Pair<String, Int>>>()
    course.forEach {
        group[it] = mutableListOf()
    }

    for (c in courseMap) {
        if (c.value <= 1) continue
        group[c.key.length]?.add(Pair(c.key, c.value))
    }

    val a = mutableListOf<String>()

    group.values.forEach { list ->
        val max = list.maxBy { it.second }?.second ?: 0
        a.addAll(list.filter { it.second == max }.map { it.first })
    }

    a.sort()
    return a.toTypedArray()
}

fun combination(arr: List<Char>, result: MutableSet<String>, level: Int, comb: String, startIndex:Int) {

    if (comb.length == level) {
        result.add(comb)
        return
    }

    for (i in startIndex until arr.size){
        combination(arr, result, level, comb.plus(arr[i]),i+1)
    }
}
