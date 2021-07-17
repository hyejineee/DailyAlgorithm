package Problems

fun fibonacci(n: Int): IntArray {
    var numberOf0 = 0
    var numberOf1 = 0

    fun fibo(n: Int): Int {
        when (n) {
            0 -> {
                numberOf0++
                return 0
            }
            1 -> {
                numberOf1++
                return 1
            }
            else -> fibo(n - 1) + fibo(n - 2)
        }
        return 0
    }

    fibo(3)

    return intArrayOf(numberOf0, numberOf1)
}



