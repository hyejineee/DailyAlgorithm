package Programmers.y2022._1104

import java.util.StringJoiner

fun 메뉴_리뉴얼(orders: Array<String>, course: IntArray): Array<String> {
    val result = mutableListOf<String>()

    course.forEach { num->
        val combi = orders.map {
            val result = mutableListOf<String>()
            combination(it.toCharArray().sortedArray(), 0, mutableListOf(), result,num)
            result
        }

        var max = 0

        countMenu(combi.flatten().toTypedArray())
            .filter { it.second >=2 }
            .sortedByDescending { it.second }
            .forEachIndexed { index, pair ->
                if(index == 0) max = pair.second

                if(max <= pair.second){
                    result.add(pair.first)
                }
            }
    }
    return result.sorted().toTypedArray()
}

fun countMenu(arr : Array<String>): List<Pair<String, Int>> = arr.groupBy { it }.map { Pair(it.key, it.value.size) }

fun combination(arr: CharArray, index: Int, temp: MutableList<Char>, result: MutableList<String>, limit: Int) {
    if(temp.size == limit){
        result.add(temp.joinToString(""))
        return
    }

    for(i in index until arr.size){
        temp.add(arr[i])
        combination(arr, i +1, temp, result, limit)
        temp.removeLast()
    }
}