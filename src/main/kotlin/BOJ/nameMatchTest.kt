package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val (name1, name2) = readLine().split(" ")

    val map = mutableMapOf<Char, Int>().apply {
        this['A'] = 3
        this['B'] = 2
        this['C'] = 1
        this['D'] = 2
        this['E'] = 4
        this['F'] = 3
        this['G'] = 1
        this['H'] = 3
        this['I'] = 1
        this['J'] = 1
        this['K'] = 3
        this['L'] = 1
        this['M'] = 3
        this['N'] = 2
        this['O'] = 1
        this['P'] = 2
        this['Q'] = 2
        this['R'] = 2
        this['S'] = 1
        this['T'] = 2
        this['U'] = 1
        this['V'] = 1
        this['W'] = 1
        this['X'] = 2
        this['Y'] = 2
        this['Z'] = 1
    }

    var matchName = ""
    val min = minOf(n, m)
    for (i in 0 until min) {
        matchName += "${name1[i]}${name2[i]}"
    }

    matchName += name1.substring(min) + name2.substring(min)

    var numbers = matchName.map { map[it]!! }.toMutableList()

    while (numbers.size > 2) {
        numbers = calculate(numbers)
    }

    val percent = numbers.joinToString("").toInt()
    println("%d".format(percent)+"%")
}

private fun calculate(numbers: MutableList<Int>): MutableList<Int> {
    val newNumbers = mutableListOf<Int>()
    for (i in 0 until numbers.size - 1) {
        var next = numbers[i] + numbers[i + 1]
        if (next >= 10) {
            next %= 10
        }
        newNumbers.add(next)
    }
    return newNumbers
}