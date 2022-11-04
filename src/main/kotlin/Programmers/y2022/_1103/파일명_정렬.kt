package Programmers.y2022._1103

import java.util.LinkedList
import kotlin.math.max

fun `파일명 정렬`(files: Array<String>): Array<String> {
    return files.mapIndexed { index, s ->
        Triple(
            index,
            s.split("[0-9]+".toRegex())[0].toLowerCase(),
            "[0-9]+".toRegex().find(s)?.value?.toLong()
        )
    }
        .sortedWith(compareBy({ it.second }, { it.third }))
        .map { files[it.first] }
        .toTypedArray()

}

//class Solution {
//    fun solution(elements: IntArray): Int {
//        val doubling = elements+elements
//        val result = HashSet<Int>()
//        for (i in 1..elements.size) {
//            result.addAll((elements.indices).map {
//                doubling.slice(it until it + i).sum()
//            })
//        }
//        return result.size
//    }
//}