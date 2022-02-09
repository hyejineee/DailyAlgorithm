package Programmers

import java.util.*

fun makeBigNumber(number: String, k: Int): String {

    val toNumber = number.map { Character.getNumericValue(it) }
    val result = mutableListOf<Int>()
    var startIndex = 0

    for (i in number.length - k downTo 1) {
        val available = toNumber.subList(startIndex, number.length - i + 1)

        var max = toNumber[startIndex]
        var maxIndex = startIndex

        for(j in startIndex .. number.length -i){
            if(max < toNumber[j]){
                max = toNumber[j]
                maxIndex = j
            }
        }

        result.add(max)
        startIndex = maxIndex +1
    }


    return result.subList(0, number.length - k).joinToString("")
}

private fun makeBigNumberWithStack(number: String, k: Int): String {
    val result = Stack<Int>()
    var count = k

    number.map { Character.getNumericValue(it) }.forEach {
        while (count > 0 && result.isNotEmpty() && result.last() < it) {
            result.pop()
            count--
        }
        result.push(it)
    }

    return result.subList(0, number.length - k).joinToString("")
}

private fun makeBigNumberWithDfs(number: String, k: Int): String {
    val level = number.length - k
    val result = mutableListOf<String>()

    for (i in 0 until number.length - k) {

        dfs(
            number[i].toString(),
            number.substring(i + 1, number.length).toMutableList(),
            result,
            1,
            level
        )
    }

    return result.map { it.toInt() }.maxBy { it }.toString() ?: ""
}

private fun dfs(num: String, needVisit: MutableList<Char>, result: MutableList<String>, curLevel: Int, level: Int) {

    if (curLevel == level) {
        result.add(num)
        return
    }

    for (i in 0..needVisit.size - (level - curLevel)) {
        dfs(
            num.plus(needVisit[i]),
            needVisit.subList(i + 1, needVisit.size),
            result,
            curLevel + 1,
            level
        )
    }
}