package Programmers

fun fatigue(k: Int, dungeons: Array<IntArray>): Int {
    val counts = mutableSetOf<Int>()
    dfs(k, dungeons, counts, 0)
    return counts.maxOrNull() ?: -1
}

private fun dfs(curP: Int, ds: Array<IntArray>, counts: MutableSet<Int>, count: Int) {

    if (ds.isEmpty()) {
        counts.add(count)
        return
    }

    for (i in ds.indices) {
        val (minP, consumedP) = ds[i]
        if (minP > curP) {
            counts.add(count)
            continue
        }
        val nx = ds.toMutableList().apply { removeAt(i) }.toTypedArray()
        dfs(curP - consumedP, nx, counts, count + 1)

    }
}

//class Solution {
//    private var answer = 0
//
//    fun solution(k: Int, dungeons: Array<IntArray>): Int {
//        val visited = BooleanArray(dungeons.size) { false }
//        findAnswer(k, dungeons, visited, 0)
//        return answer
//    }
//
//    fun findAnswer(k: Int, dungeons: Array<IntArray>, visited: BooleanArray, count: Int) {
//        for (i in dungeons.indices) {
//            if (visited[i] == false && k >= dungeons[i][0]) {
//                visited[i] = true
//                findAnswer(k - dungeons[i][1], dungeons, visited, count + 1)
//                visited[i] = false
//            }
//        }
//
//        if (count > answer) {
//            answer = count
//        }
//    }
//}