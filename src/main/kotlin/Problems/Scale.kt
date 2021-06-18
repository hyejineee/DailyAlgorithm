package Problems

fun scale(scale: IntArray): String {

    val sum = (0..scale.size - 2).foldIndexed(0) { value: Int, acc: Int, index: Int ->
        println("${value} : ${index} : ${acc}")
        val step: Int = scale[index] - scale[index + 1]

        if (step != -1 && step != 1) {
            return "mixed"
        }

        acc + step
    }

    return if (sum > 0) {
        "descending"
    } else {
        "ascending"
    }

}