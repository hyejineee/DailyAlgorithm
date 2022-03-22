package Programmers

import thisIsCodingTest.untilBecomes1

fun candidateKey(relation: Array<Array<String>>): Int {
    val idxs = List<Int>(relation[0].size) { it }
    val keys = mutableListOf<List<Int>>()

    for (i in 1 until relation.size) {
        val combi = mutableListOf<List<Int>>()
        combination(combi, idxs, BooleanArray(idxs.size) { false }, 0, i)

        for (j in combi) {
            if (checkMin(j, keys).not()) continue
            checkUnique(j, keys, relation)
        }
    }
    return keys.size
}

private fun checkMin(combi: List<Int>, unique: MutableList<List<Int>>): Boolean {
    val result = mutableListOf<List<Int>>()
    for (i in 1..combi.size) {
        val c = mutableListOf<List<Int>>()
        combination(c, combi, BooleanArray(combi.size) { false }, 0, i)
        c.forEach {
            result.add(it)
        }
    }

    result.forEach {
        if (it in unique) return false
    }
    return true
}

private fun checkUnique(combi: List<Int>, unique: MutableList<List<Int>>, relation: Array<Array<String>>) {
    val keys = mutableSetOf<String>()
    for (i in relation.indices) {
        val t = relation[i]
        var cs = ""
        for (j in combi) {
            cs += t[j]
        }
        keys.add(cs)
    }
    println("uni : ${unique}")
    println("combi : $combi makes : $keys")
    if (keys.size == relation.size) unique.add(combi)
}

private fun combination(result: MutableList<List<Int>>, el: List<Int>, ck: BooleanArray, start: Int, target: Int) {
    if (target == 0) {
        result.addAll(listOf(el.filterIndexed { index, _ -> ck[index] }))
    } else {
        for (i in start until el.size) {
            ck[i] = true
            combination(result, el, ck, i + 1, target - 1)
            ck[i] = false
        }
    }
}