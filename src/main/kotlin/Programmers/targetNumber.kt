package Programmers

fun targetNumber(numbers: IntArray, target: Int): Int {

    var result = 0
    fun sum(sum: Int, level: Int) {

        println("sum : $sum, level : $level")

        if (level == numbers.size) {
            if (sum == target) {
                result += 1
                return
            }
        }

        if (level < numbers.size) {
            sum(sum + numbers[level], level + 1)
            sum(sum - numbers[level], level + 1)
        }
    }

    sum(numbers[0], level = 1)
    sum(-numbers[0], level = 1)


    return result
}

//우수 답안
class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { list, i ->
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
    }
}





