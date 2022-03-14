package Programmers

import java.util.*

fun doublePriorityQueue(operations: Array<String>): IntArray {

    val queue = LinkedList<Int>()

    for (i in operations) {
        val (op, data) = i.split(" ")

        if(op == "I"){
            queue.add(data.toInt())
            continue
        }

        if(queue.isEmpty()) continue

        queue.sort()

        if(data.toInt() == 1) queue.pollLast() else queue.pollFirst()

    }

    return intArrayOf(queue.maxBy { it }?:0, queue.minBy { it }?:0)
}