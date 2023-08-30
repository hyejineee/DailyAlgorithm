package inflearn

fun cps2(arr: IntArray, m: Int): Int {
    var p1 = 0
    var p2 = 0
    var count = 0

    while (p2 < arr.size) {
        if (arr.slice(p1..p2).sum() <= m) {
            count++
            p2++
            continue
        }
        p1++
    }

    return count + arr.filter { it <= m }.count()
}