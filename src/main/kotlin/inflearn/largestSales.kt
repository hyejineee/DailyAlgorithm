package inflearn

import kotlin.math.max

fun largestSales(arr : IntArray, k : Int): Int{
    var sum = arr.slice(0 until k).sum()
    var max = sum

    for(i in 1 until  arr.size-2) {
        sum = sum + arr[i + 2] - arr[i - 1]
        max = max(max, sum )
    }
    return max
}