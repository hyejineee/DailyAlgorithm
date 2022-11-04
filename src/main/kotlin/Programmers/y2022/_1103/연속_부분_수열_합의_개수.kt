package Programmers.y2022._1103

import java.util.LinkedList
import kotlin.math.max

data class Node(val head: Boolean, val value: Int)

fun `연속 부분 수열 합의 개수`(elements: IntArray): Int {
    val arr = LinkedList(elements.mapIndexed { index, i -> Node(head = index == 0, value = i) })
    val result = mutableSetOf<Int>()

    for(i in 1 .. elements.size){
        while (true){
            var sum = 0
            for(j in 0 until i ){
                sum += arr[j].value
            }

            result.add(sum)
            arr.offerLast(arr.pollFirst())
            println(arr)

            if(arr.first.head) break
        }
    }

    return result.size
}