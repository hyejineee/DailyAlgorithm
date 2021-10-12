package Problems

fun numberSort3(numbers: Array<Int>): Array<Int> {
    val countArray = IntArray(10001, { 0 })
    val result = mutableListOf<Int>()
    
    numbers.forEach {
        countArray[it]++
    }

    countArray.forEachIndexed { index, i ->
        for (j in 1..i) {
            result.add(index)
        }
    }

    return result.toTypedArray()
}