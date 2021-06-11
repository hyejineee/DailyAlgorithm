package Problems

import java.util.*

fun stackSequence(n: Int, sequence: IntArray): List<String> {

    var stack = Stack<Int>()
    var sequenceStack = Stack<Int>()

    sequence.reversed().forEach {
        sequenceStack.push(it)
    }

    var count = 1
    var result = mutableListOf<String>()

    for (i in 0 until n) {

        while (count <= sequence[i]) {
            stack.push(count)
            count += 1
            result.add("+")
        }

        if (stack.peek() == sequence[i]) {
            stack.pop()
            result.add("-")
        } else {
            print("No")
        }
    }

    return result
}