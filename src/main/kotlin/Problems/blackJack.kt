package Problems

fun blackJack(cards: IntArray, maxNum: Int): Int {
    var result = 0

    for (i in cards.indices) {
        for (j in i + 1 until cards.size) {
            for (k in j + 1 until cards.size) {
                val sum = cards[i] + cards[j] + cards[k]

                if (sum in (result + 1)..maxNum) {
                    result = sum
                }
            }
        }
    }

    return result
}