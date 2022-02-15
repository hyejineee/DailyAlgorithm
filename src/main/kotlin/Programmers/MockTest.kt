package Programmers

private val ints = arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

fun mockTest(answers: IntArray): IntArray {

    val supo1 = arrayOf(1, 2, 3, 4, 5)
    val supo2 = arrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val supo3 = arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    val score = mutableMapOf(1 to 0, 2 to 0, 3 to 0)

    answers.forEachIndexed { index, i ->
        if (i == supo1[index % supo1.size]) {
            score[1] = score[1]?.plus(1) ?: 0
        }
        if (i == supo2[index % supo2.size]) {
            score[2] = score[2]?.plus(1) ?: 0
        }
        if (i == supo3[index % supo3.size]) {
            score[3] = score[3]?.plus(1) ?: 0
        }

    }

    val max = score.maxBy { it.value }?.value?:-1
    return score.filter { it.value == max }.toSortedMap().map { it.key }.toIntArray()
}