package Programmers.y2022._1105

import javax.xml.stream.events.Characters

class Winter {

    fun solution1(str: String): String {
        var result = str
        for (i in 97..122) {
            val c = i.toChar()
            val reg = "${c}{2,}".toRegex()
            result = result.replace(reg, "${c}*")
        }
        return result
    }

    fun solution2(n: Int, student: IntArray, point: IntArray): Int {
        val half = n / 2
        var dominant = List(half) { it + 1 }

        val record = mutableMapOf<Int, Int>()
        for (i in 1..n) {
            record[i] = 0
        }

        var count = 0
        student.forEachIndexed { index, s ->
            record[s] = record[s]?.plus(point[index]) ?: 1
            val arr = record.toList().sortedByDescending { it.second }
            val d = arr.subList(0, half).map { it.first }

            if(!d.containsAll(dominant)){
                dominant = d
                count++
            }
        }

        return count
    }

    fun solution3(worldMap: Array<String>): Int {
        return 0
    }
}