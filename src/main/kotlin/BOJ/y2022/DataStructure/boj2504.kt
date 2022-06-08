package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val p = readLine()

    val infix = mutableListOf<Char>()

    val check1 = Stack<Char>()
    val check2 = Stack<Char>()

    if (p[0] == ']' || p[0] == ')') {
        println(0)
        return@with
    }

    if (p[0] == '(') {
        infix.add('2')
        check1.add('(')
    } else if (p[0] == '[') {
        infix.add('3')
        check2.add('[')
    }

    for (i in 1 until p.length) {
        when (p[i]) {
            '(', '[' -> {
                if (p[i - 1] == '(' || p[i - 1] == '[') {
                    infix.add('*')
                    infix.add('(')
                } else {
                    infix.add('+')
                }

                if (p[i] == '(') {
                    infix.add('2')
                    check1.push('(')
                } else {
                    infix.add('3')
                    check2.push('[')
                }
            }

            else -> {

                if (p[i] == ')' && p[i - 1] == '[') {
                    println(0)
                    return@with
                }

                if (p[i] == ']' && p[i - 1] == '(') {
                    println(0)
                    return@with
                }

                try {
                    if (p[i] == ')') check1.pop()
                    if (p[i] == ']') check2.pop()
                } catch (e: EmptyStackException) {
                    println(0)
                    return@with
                }

                infix.add(')')
            }
        }
    }

    if (check1.isNotEmpty() || check2.isNotEmpty()) {
        println(0)
        return@with
    }

    val postfix = mutableListOf<Char>()
    val op = Stack<Char>()
    for (i in infix.indices) {

        if (infix[i].isDigit()) {
            postfix.add(infix[i])
        } else if (infix[i] == '(') {
            op.push(infix[i])
        } else if (infix[i] == ')') {
            var pop = '!'
            while (pop != '(' && op.isNotEmpty()) {
                pop = op.pop()
                if (pop != '(') {
                    postfix.add(pop)
                }
            }
            if (op.isNotEmpty()) postfix.add(op.pop())
        } else {
            op.push(infix[i])
        }
    }

    while (op.isNotEmpty()) {
        postfix.add(op.pop())
    }

    val numStack = Stack<Int>()

    postfix.forEach {
        if (it.isDigit()) {
            numStack.push(Character.getNumericValue(it))
        } else {
            if (numStack.isNotEmpty()) {

                val n2 = numStack.pop()
                val n1 = numStack.pop()
                when (it) {
                    '*' -> {
                        numStack.push(n1 * n2)
                    }
                    else -> numStack.push(n1 + n2)
                }
            }
        }
    }

    println(if (numStack.isNotEmpty()) numStack.pop() else 0)
}

