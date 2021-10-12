package Programmers

fun mutualEvaluation(scores: Array<IntArray>): String = Array(scores.size) { i ->
    val myScore = (scores.indices).fold(mutableListOf<Int>()) { acc, j ->
        acc.add(scores[j][i])
        acc
    }

    if (myScore.filter { it == scores[i][i] }.size <= 1 && (scores[i][i] == myScore.max() || scores[i][i] == myScore.min())) {
        myScore.removeAt(i)
    }

    (myScore.sum() / myScore.size.toDouble()).let {
        when {
            it >= 90 -> "A"
            it >= 80 -> "B"
            it >= 70 -> "C"
            it >= 50 -> "D"
            else -> "F"
        }
    }
}.joinToString("")
