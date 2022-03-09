package Programmers

import java.util.*

fun parenthesesConversion(p: String): String {

    if (p.isBlank() || p.isEmpty()) return ""


    val sb = StringBuilder()

    for (i in p.indices) {
        println("ch : ${p[i]}")
        sb.append(p[i])

        val u = sb.toString()
        val v = p.substring(i+1, p.length)

        println("index :$i, u:$u, v:$v")

        if (checkBalance(u)) {
            if (checkRight(u)) {
                return u + parenthesesConversion(v)
            } else {
                val temp = StringBuilder().apply { append("(") }
                temp.append(parenthesesConversion(v))
                temp.append(")")

                val flip = StringBuilder()

                for(c in u.toString().substring(1, u.length -1)){
                    when(c){
                        '(' -> flip.append(')')
                        ')' ->flip.append('(')
                        else -> flip.append("")
                    }
                }

                println("temp : $temp, flip : $flip ${u.substring(1, u.length - 1).length} u:$u")

                temp.append(flip)
                return temp.toString()
            }
        } else {
            continue
        }
    }

    return ""

}

private fun checkRight(s: String): Boolean {
    val stack = Stack<Char>()

    for (i in s) {
        if (i == '(') {
            stack.push(i)
            continue
        }

        if (stack.isNotEmpty()) stack.pop()
    }

    return stack.isEmpty()
}

private fun checkBalance(s: String): Boolean {
    var openCount = 0
    var closeCount = 0

    for (i in s) {
        if (i == '(') openCount++ else closeCount++
    }

    return openCount == closeCount
}