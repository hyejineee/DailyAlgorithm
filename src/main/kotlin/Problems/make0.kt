package Problems

fun make0(n: Int): List<String> {
    val operators = mutableListOf<List<Char>>()
    makeOperators(emptyList(), n - 1, operators)

    val result = mutableListOf<String>()
    val numbers = Array(n) {
        it + 1
    }

    operators.forEach {
        var formula = ""
        for (i in 0 until n - 1) {
            formula += numbers[i].toString() + it[i]
        }

        formula += numbers.last()

        if (calculate(formula.replace(" ", "")) == 0) {
            result.add(formula)
        }
    }
    return result.sorted().toList()
}

fun calculate(formula: String): Int {

    val opers = formula.filter { it == '+' || it == '-' }
    val numbers = formula.split("+", "-")

    var result = numbers.first().toInt()

    opers.forEachIndexed { index, c ->
        when (c) {
            '+' -> result += numbers[index + 1].toInt()
            else -> result -= numbers[index + 1].toInt()
        }
    }

//    println("formular : $formula, result : $result")
    return result
}

fun makeOperators(operator: List<Char>, size: Int, operators: MutableList<List<Char>>) {

    if (operator.size == size) {
        operators.add(operator)
        return
    } else {
        val spaceTemp = operator.toMutableList().apply {
            add(' ')
        }
        makeOperators(spaceTemp, size, operators)

        val plusTemp = operator.toMutableList().apply {
            add('+')
        }
        makeOperators(plusTemp, size, operators)

        val minusTemp = operator.toMutableList().apply {
            add('-')
        }
        makeOperators(minusTemp, size, operators)
    }
}