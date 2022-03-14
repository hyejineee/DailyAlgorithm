package Programmers

fun hIndex(numbers:IntArray):Int{
    val count = mutableMapOf<Int, Int>()

    for(i in 1..(numbers.maxOrNull()?:1)){
        count[i] = 0
    }

    for(i in 1 until count.size){
        count[i] = numbers.count { it >= i }
    }

    return count.filter { it.key <=it.value }.keys.lastOrNull()?:0
}