package Programmers

fun getReportedResult(id_list: Array<String>, report: Array<String>, k: Int): IntArray {

    val m = HashMap<String, MutableSet<String>>()
    val reportedCount = HashMap<String, Int>()

    id_list.map {
        m[it] = mutableSetOf()
        reportedCount[it] = 0
    }

    report.toSet().forEach {
        val (repoter, reported) = it.split(" ")
        m[repoter]?.add(reported)
        reportedCount[reported] = reportedCount[reported]?.plus(1) ?: 0
    }

    return id_list.map {
        m[it]?.count { reported -> (reportedCount[reported] ?: 0) >= k } ?:0
    }.toIntArray()
}

//class Solution {
//    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
//        report.map { it.split(" ") }
//            .groupBy { it[1] }
//            .asSequence()
//            .map { it.value.distinct() }
//            .filter { it.size >= k }
//            .flatten()
//            .map { it[0] }
//            .groupingBy { it }
//            .eachCount()
//            .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }
//}