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