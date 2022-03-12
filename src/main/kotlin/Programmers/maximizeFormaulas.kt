package Programmers

import kotlin.math.abs

fun maximizeFormulas(expression: String): Long {

    val op = listOf("*", "+", "-")
    val cases = dfs(op, "*", listOf(), mutableListOf())

    var ex = expression
    op.forEach {
        ex = ex.replace(it.toString(), " $it ")
    }

    return cases.map { calculate(it, ex.split(" ")) }.maxOrNull()?:-1
}

private fun calculate(priorityOps: List<String>, expression: List<String>): Long {
    var result = expression.toMutableList()

    priorityOps.forEach {
        while (it in result){
            val opIndex = result.indexOf(it.toString())
            if(opIndex ==-1) break

            val num1 = result[opIndex-1].toLong()
            val num2 = result[opIndex+1].toLong()

            val v:Long = when(it){
                "*" -> num1 * num2
                "+" -> num1 + num2
                else -> num1 - num2
            }

            val new = result.subList(0, opIndex-1).plus(v.toString()).plus(result.subList(opIndex+2, result.size))
            println("op :$it , result :$new")
            result = new.toMutableList()
        }
    }
    return abs(result[0].toLong())
}

private fun dfs(ops: List<String>, cur: String, priority: List<String>, result: MutableList<List<String>>): List<List<String>> {

    if (ops.isEmpty()) {
        result.add(priority)
        return result
    }

    for (i in ops) {
        val nop = ops.toMutableList().apply { remove(i) }
        dfs(nop, i, priority.plus(i), result)
    }

    return result
}