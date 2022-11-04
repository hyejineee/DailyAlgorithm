package Programmers.y2022._1103

import java.util.LinkedList
import kotlin.math.max

data class Node(val head: Boolean, val value: Int)

fun `연속 부분 수열 합의 개수`(elements: IntArray): Int {
    val arr = elements.mapIndexed { index, i -> Node(head = index == 0, value = i) }.toMutableList()
    val result = mutableSetOf<Int>()

    for(i in 1 .. elements.size){
        while (true){
            var sum = 0
            for(j in 0 until i ){
                sum += arr[j].value
            }

            result.add(sum)
            arr.add(arr.removeAt(0))

            if(arr.first().head) break
        }
    }

    return result.size
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