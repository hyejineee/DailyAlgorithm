package Programmers

fun expressedAsN(N: Int, number: Int): Int {
    val arr = Array(9) {
        if (it > 0) {
            mutableSetOf<Int>("$N".repeat(it).toInt())
        } else {
            mutableSetOf()
        }
    }

    arr[2].addAll(arrayOf(N * 2, 0, 1, N * N))

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

            arr.add(j - i)
            if (i != 0) {
                arr.add(j / i)
            }
            if (j != 0) {
                arr.add(i / j)
            }
        }
    }
    return arr
}