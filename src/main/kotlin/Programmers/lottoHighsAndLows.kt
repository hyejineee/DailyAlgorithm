package Programmers

fun lottoHighsAndLows(lottos: IntArray, win_nums: IntArray): IntArray {

    val ranking = hashMapOf(6 to 1, 5 to 2, 4 to 3, 3 to 4, 2 to 5, 1 to 6, 0 to 6)
    val correct = lottos.filter { it !=0 }.count { it in win_nums }
    val incorrect = lottos.filter { it!=0 }.count { it in win_nums }
    val zero = lottos.count { it == 0 }

    return intArrayOf(ranking[correct + zero]!!, ranking[6-incorrect-zero]!!)
}