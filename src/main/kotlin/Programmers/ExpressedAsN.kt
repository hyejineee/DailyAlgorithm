package Programmers

fun expressedAsN(N: Int, number: Int): Int {
    val arr = Array(9) {
        if (it > 0) {
            mutableSetOf<Int>("$N".repeat(it).toInt())
        } else {
            mutableSetOf()
        }
    }

    for (i in arrayOf("+", "-", "/", "*")) {
        val r = when (i) {
            "+" -> N + N
            "-" -> N - N
            "/" -> N / N
            "*" -> N * N
            else -> 0
        }
        arr[2].add(r)
    }

    if (N == number) return 1
    if (number in arr[2]) return 2

    for (i in 3 until 9) {
        for (j in 1 until i) {
            combination(arr[j], arr[i - j], arr[i])
        }

        if (number in arr[i]) {
            return i
        }
    }
    return -1
}

private fun combination(arr1: MutableSet<Int>, arr2: MutableSet<Int>, arr: MutableSet<Int>): MutableSet<Int> {
    for (i in arr1) {
        for (j in arr2) {
            arr.add(i + j)
            arr.add(i - j)
            arr.add(i * j)

            if (j != 0) {
                arr.add(i / j)
            }
        }
    }

    for (i in arr2) {
        for (j in arr1) {
            arr.add(i - j)
            if (j != 0) {
                arr.add(i / j)
            }
        }
    }
    return arr
}