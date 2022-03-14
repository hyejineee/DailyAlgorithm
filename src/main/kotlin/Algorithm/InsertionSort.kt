package Algorithm

fun insertionSort(data: IntArray): IntArray {

    var copyOfData = data.toMutableList()
    for (i in 1 until copyOfData.size) {
        for (j in i downTo 1) {
            if (copyOfData[j] < copyOfData[j - 1]) {
                copyOfData.also {
                    val temp = it[j]
                    it[j] = it[j - 1]
                    it[j - 1] = temp
                }
            } else {
                continue
            }
        }
    }
    return copyOfData.toIntArray()
}