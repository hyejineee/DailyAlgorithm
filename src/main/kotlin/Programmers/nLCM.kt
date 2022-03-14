package Programmers

fun nLCM(arr: IntArray): Int {

    val max = arr.maxOrNull() ?: 0
    var i = 0

    while (true) {
        if (aliquot(max * i).containsAll(arr.asList())) {
            break
        }
        i++
    }

    return i * max
}

fun aliquot(num: Int): List<Int> {
    val aliquots = mutableListOf<Int>()
    var i = 1

    while (i * i <= num) {
        if (num % i == 0) {
            aliquots.add(i)
            aliquots.add(num / i)
        }
        i++
    }

    return aliquots.sorted()
}

