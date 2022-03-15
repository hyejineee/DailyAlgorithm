package thisIsCodingTest

fun countTheNumber(array: IntArray, target: Int): Int {

    var start = 0
    var end = array.size - 1
    var count = 0
    if (target !in array.first()..array.last()) return -1

    while (start <= end) {
        val mid = (start + end) / 2

        if (array[mid] == target) {
            for (i in start..end) {
                if (array[i] == target) count++
            }
            break
        }

        if (array[mid] > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return count
}