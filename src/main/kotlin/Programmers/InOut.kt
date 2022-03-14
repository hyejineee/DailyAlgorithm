package Programmers

import java.util.*

fun inOut(enterOrder: IntArray, leaveOrder: IntArray): IntArray {
    val count = MutableList(enterOrder.size) { mutableSetOf<Int>() }

    val leave: Queue<Int> = LinkedList<Int>().apply {
        leaveOrder.forEach {
            this.add(it)
        }
    }

    val enter = mutableListOf<Int>()

    for (element in enterOrder) {
        enter.add(element)

        enter.forEach { i ->
            count[i - 1].addAll(enter.filter { it != i })
        }

        while (leave.isNotEmpty()) {
            if (leave.peek() !in enter) break

            val pop = leave.poll()
            enter.remove(pop)
        }
    }
    return count.map { it.size }.toIntArray()
}

