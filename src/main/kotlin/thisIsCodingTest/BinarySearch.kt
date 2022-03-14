package thisIsCodingTest

class BinarySearch {

    fun findPart(storePart: IntArray, customerPart: IntArray): String {
        storePart.sort()

        return customerPart.map { if (searchPart(storePart, it)) "yes" else "no" }.joinToString(" ")
    }

    private fun searchPart(part: IntArray, target: Int): Boolean {
        var start = 0
        var end = part.size - 1

        while (start <= end) {
            val mid = (start + end) / 2

            if (part[mid] == target) return true
            if (part[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return false
    }

    fun makeRiceCake(n: Int, m: Int, highs: IntArray): Int {
        var start = 0
        var end = highs.max() ?: 0

        while (start <= end) {
            val mid = (start + end) / 2

            val target = highs.fold(0) { acc, i ->
                if (mid >= i) acc else acc.plus(i - mid)
            }

            if (target == m) return mid

            if (target > m) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return 0
    }
}