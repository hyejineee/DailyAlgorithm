package Programmers

fun failureLate(stage: Int, stages: IntArray): IntArray =
    (1..stage).map { currentStage: Int ->
        val failureLate = (stages.count { it == currentStage }.toFloat() / stages.count { currentStage <= it })
        Pair(currentStage, if (failureLate.isNaN()) 0.0F else failureLate)
    }.sortedByDescending { it.second }
        .map { it.first }
        .toIntArray()


