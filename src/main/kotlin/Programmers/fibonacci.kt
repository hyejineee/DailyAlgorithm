package Programmers

fun fibonacci(n: Int): Int {
    val f = MutableList(n + 1) { 0 }

    for (i in 0..n) {
        f[i] = when (i) {
            0 -> 0
            1 -> 1
            else -> {
                (f[i - 1] + f[i - 2]) % 1234567
            }
        }
    }

    return f[n]
}
