package thisIsCodingTest

fun change(n: Int): Int {
    var remain = n
    val changes = intArrayOf(500, 100, 50, 10)
    var count = 0

    for (i in changes) {
        if (remain / i > 0) {
            count += (remain / i)
            remain %= i

        }
    }

    return count
}

fun lawOfLargeNumber(m: Int, k: Int, numbers: IntArray): Int {
    numbers.sortDescending()

    val max = numbers[0]
    val second = numbers[1]
    val count = (m / k) * k

    return (count * max) + ((m - count) * second)
}


