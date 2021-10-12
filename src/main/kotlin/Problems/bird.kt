package Problems

fun bird(n: Int): Int {
    var remainBird = n
    var k = 1
    var count = 0

    while (remainBird > 0) {
        println(remainBird)
        if (remainBird < k) {
            k = 1
        } else {
            remainBird -= k
            k++
            count++
        }
    }
    return count
}