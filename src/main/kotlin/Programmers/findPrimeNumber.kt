package Programmers

fun findPrimeNumber(numbers: String): Int {
    val makeNumbers = mutableSetOf<Int>()

    numbers.toCharArray().forEach { n ->
        dfs(
            n.toString(),
            numbers.map { Character.getNumericValue(it) }.toMutableList().apply { this.remove(Character.getNumericValue(n)) },
            1,
            numbers.length,
            makeNumbers
        )
    }
    return makeNumbers.count { it.isPrime() }
}

private fun dfs(num: String, available: MutableList<Int>, curLevel: Int, level: Int, numbers: MutableSet<Int>) {

    if(num.toInt() > 1){
        numbers.add(num.toInt())
    }

    if (curLevel == level) {
        return
    }

    for (i in available) {
        val next = num.plus(i.toString())
        dfs(next, available.toMutableList().apply { remove(i) }, curLevel + 1, level, numbers)
    }
}

private fun Int.isPrime(): Boolean {
    var i =2
    while (i*i <= this){
        if(this%i == 0) return false
        i++
    }
    return true
}