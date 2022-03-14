package Programmers


fun sortBoxer(weights: IntArray, head2head: Array<String>): IntArray = Array(weights.size) { index ->
    val winningRate =
        head2head[index].count { it == 'W' }.toDouble() / head2head[index].count { it == 'W' || it == 'N' }
    val numberOfWinsHeavier =
        head2head[index].filterIndexed { index2, c -> c == 'W' && weights[index2] > weights[index] }.count()

    BoxerInfo(index, weights[index], winningRate, numberOfWinsHeavier)
}
    .sorted()
    .map {
        println(it)
        it.boxerNumber + 1
    }
    .toIntArray()


//class Solution {
//    fun solution(weights: IntArray, head2head: Array<String>): IntArray {
//        val listOfWin = head2head.map {
//            it.indices.filter { index -> it[index] == 'W' }
//        }
//        val countOfFight = head2head.map {
//            it.filter { c -> c != 'N' }.count()
//        }
//        val countOfWinOverWeight = listOfWin.mapIndexed { index, it ->
//            it.filter { weights[index] < weights[it] }.count()
//        }
//        return weights.indices
//            .sortedByDescending { weights[it] }
//            .sortedByDescending { countOfWinOverWeight[it] }
//            .sortedByDescending { listOfWin[it].count() / Math.max(countOfFight[it], 1).toDouble() }
//            .map { it + 1 }
//            .toIntArray()
//    }
//}


//
