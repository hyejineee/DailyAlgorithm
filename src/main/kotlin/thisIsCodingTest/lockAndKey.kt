package thisIsCodingTest

fun lockAndKey(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
    val n = lock.size
    val m = key.size
    val bsize = n + ((m-1)*2)
    var temp = key

    for (r in 0 until 4) {
        for (i in 0 until bsize) {
            for (j in 0 until bsize) {
                if (checkKey(temp, lock, i, j, m, bsize)) {
                    println("start : $i,$j")
                    return true
                }
            }
        }
        temp = rotate90(temp, m)
    }

    return false
}

private fun checkKey(key: Array<IntArray>, lock: Array<IntArray>, x: Int, y: Int, m:Int, bsize :Int): Boolean {
    val temp = Array<IntArray>(bsize) { i ->
        IntArray(bsize) { j ->
            if (i in key.size-1 until bsize-(key.size-1) && j in key.size-1 until bsize-(key.size-1)) lock[i -(key.size-1)][j - (key.size-1)] else 0
        }
    }

    println()
    temp.forEach { println(it.toList()) }
    println()
    for (i in 0 until m ) {
        for (j in 0 until m) {

            if (x + i in 0 until bsize && y + j in 0 until bsize) {
                temp[x + i][y + j] = temp[x + i][y + j] xor key[i][j]
            }

        }
    }

    for (i in key.size-1 until bsize-(key.size-1)) {
        for (j in key.size-1 until bsize-(key.size-1)) {
            if (temp[i][j] != 1) return false
        }
    }

    return true
}

private fun rotate90(arr: Array<IntArray>, n: Int): Array<IntArray> {
    val temp = Array(n) { IntArray(n) { 0 } }

    for (i in arr.indices) {
        for (j in arr.indices) {
            temp[j][n - i - 1] = arr[i][j]
        }
    }
    return temp
}