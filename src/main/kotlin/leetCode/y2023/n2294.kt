package leetCode.y2023

fun partitionArray(nums: IntArray, k: Int): Int {
    val sorted = nums.sortedArray()

    var p1 = 0
    var p2 = 0
    var count = 0

    while (p2 < nums.size ){
        while (p2 < nums.size && sorted[p2] - sorted[p1] <=k) {
            p2++
            continue
        }
        count++
        p1 = p2
    }

    return count
}