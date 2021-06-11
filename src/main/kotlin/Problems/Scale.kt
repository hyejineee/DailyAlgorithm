package Problems

fun scale(scale: IntArray): String {
    var sum = 0

    for (i in 0..scale.size - 2) {
        val step = scale[i] - scale[i + 1]

        if (step != -1 && step != 1) {
            return "mixed"
        }

        sum += step

    }

    return if (sum > 0) {
        "descending"
    } else {
        "ascending"
    }

}