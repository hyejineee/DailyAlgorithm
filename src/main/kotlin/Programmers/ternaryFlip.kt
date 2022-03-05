package Programmers

import javax.xml.stream.events.Characters
import kotlin.math.pow

fun ternaryFlip(n:Int) = convertDecimal(convertTernary(n).reversed())

private fun convertTernary(num:Int): String {
    var n = num
    val sb = StringBuilder()

    while (n / 3 > 0){
        sb.append(n%3)
        n /= 3
    }

    sb.append(n%3)
    return sb.toString()
}

private fun convertDecimal(num:String): Int {
    var result = 0
    for(i in num.indices){
        result += (Character.getNumericValue(num[i]) * 3.0.pow(i)).toInt()
    }
    return result
}

