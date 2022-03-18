package Programmers

import java.util.*

fun rotateParentheses(s: String): Int {

    var changed = s
    var count = 0
    for (i in s.indices) {
        if(checkRight(changed)){
            count++
        }

        val temp = changed.take(1)
        changed = changed.drop(1) + temp
    }

    return count
}

private fun checkRight(s: String): Boolean {
    val stack = Stack<Char>()

    for (i in s) {
        if(i in arrayOf('(','{','[')){
            stack.push(i)
            continue
        }

        if(stack.isEmpty()) return false

        val p = stack.peek()
        if((i == ')' && p =='(') || (i=='}' && p =='{') || (i==']' && p=='[')){
            stack.pop()
            continue
        }
    }
    return stack.isEmpty()
}