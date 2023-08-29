package inflearn

fun mergeTwoArray(arr1: IntArray, arr2: IntArray): IntArray {
    var p1 = 0
    var p2 = 0

    val result = mutableListOf<Int>()

    while ((p1 < arr1.size && p2 < arr2.size)) {
        if (arr1[p1] <= arr2[p2]) {
            result.add(arr1[p1])
            p1++
            continue
        }

        result.add(arr2[p2])
        p2++
    }


    for(i in p1 until arr1.size){
        result.add((arr1[i]))
    }

    for (i in p2 until arr2.size) {
        result.add(arr2[i])
    }

    println(result)
    return result.toIntArray()
}