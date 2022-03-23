package Programmers

import java.lang.StringBuilder

fun differentBits(numbers: LongArray): LongArray {
    return numbers.map {
        val result = findNumberOfDifferentBits(it)
        println(result)
        result
    }.toLongArray()
}

private fun findNumberOfDifferentBits(num:Long): Long {
    var i:Long = num +1
    if(num %2 == 0L) return num+1 else{
        val bits = num.toString(2).toMutableList()
        if(bits.contains('0')){
            val idx = bits.lastIndexOf('0')
            bits[idx] = '1'
            bits[idx+1] = '0'
        }else{
            bits.add(1,'0')
        }

        return bits.joinToString("").toLong(2)
    }
//    while (i<=1000000000000000){
//        val differCount = (num xor i).toString(2).count { it=='1' }
//        if(differCount <=2) return i
//        i++
//    }
    return 0
}


//class Solution {
//    fun solution(numbers: LongArray): LongArray {
//        return numbers.map { num -> (num.inv() and num + 1).let { num or it and (it shr 1).inv() } }.toLongArray()
//    }
//}

//private fun findNumberOfDifferentBits(num: Long): Long {
//    val bits = (0 until num.countLeadingZeroBits()).fold(StringBuilder()) { acc, i -> acc.append(0) }.apply {
//        append(num.toString(2))
//    }
//    var i: Long = num + 1
//    while (i <= 1000000000000000) {
//
//        val targetBits = (0 until i.countLeadingZeroBits()).fold(StringBuilder()) { acc, i -> acc.append(0) }.apply {
//            append(i.toString(2))
//        }
//
//        val differCount = bits.filterIndexed { index, c -> c != targetBits[index] }.length
//
//        if (differCount <= 2) return i
//        i++
//    }
//    return 0
//}