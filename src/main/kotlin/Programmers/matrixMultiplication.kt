package Programmers

fun matrixMultiplication(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    val rotatedArr2 = rotate(arr2)

    return Array(arr1.size) { i ->
        IntArray(rotatedArr2.size) { j ->
            var sum = 0
            for (k in arr1[i].indices) {
                sum += arr1[i][k] * rotatedArr2[j][k]
            }
            sum
        }
    }
}

fun rotate(arr: Array<IntArray>): Array<IntArray> {
    val new = MutableList(arr[0].size) {
        MutableList(arr.size) { 0 }
    }

    for (i in arr.indices) {
        for (j in arr[i].indices) {
            new[j][i] = arr[i][j]
        }
    }
    return new.map { it.toIntArray() }.toTypedArray()
}