package Problems

fun sortNumber2(array: IntArray) = array.sortedArray().joinToString("") {
    it.toString() + "\n"
}