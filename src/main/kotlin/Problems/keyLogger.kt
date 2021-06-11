package Problems

import java.util.*

fun keyLogger(input: String): String {
    val right = Stack<Char>()
    val left = Stack<Char>()
    
    input.forEach {
        when (it) {
            '-' -> {
                if (right.isNotEmpty()) {
                    right.pop()
                }
            }
            '<' -> {
                if (right.isNotEmpty()) {
                    left.push(right.pop())
                }
            }
            '>' -> {
                if (left.isNotEmpty()) {
                    right.push(left.pop())
                }
            }
            else -> right.push(it)
        }

    }

    return (right + left).joinToString("") {
        it.toString()
    }
}