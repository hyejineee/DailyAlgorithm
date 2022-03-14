package Problems

fun trophyDisplay(tropies: IntArray): IntArray {

    val left = counting(tropies)
    val right = counting(tropies.reversedArray())

    return intArrayOf(left, right)
}

fun counting(tropies: IntArray): Int {
    var highest = 0
    var count = 0
    for (trophy in tropies) {
        if (trophy > highest) {
            count++
            highest = trophy
        }
    }
    return count
}