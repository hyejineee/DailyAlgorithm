package codility

fun rotateArray(A: IntArray, K: Int): IntArray {

    if(A.isEmpty()) return intArrayOf()

    val testArr = A.toMutableList()

    for(i in 0 until K){
        testArr.add(0,testArr.last())
        testArr.removeAt(testArr.size-1)
    }

    return testArr.toIntArray()
}