package Programmers

import java.util.*

fun numberStringAndEnWord(s: String): Int {
    var result = s
    val numEn = hashMapOf(
        "zero" to 0, "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6,
        "seven" to 7, "eight" to 8, "nine" to 9
    ).forEach { t, u ->
        result = result.replace(t, u.toString())
    }

    return result.toInt()

//    val numStack = Stack<Int>()
//    val stack = Stack<Char>()
//    for(i in s){
//        if(i.isLetter()) {
//            stack.push(i)
//            numEn[stack.joinToString("")]?.let {
//                numStack.push(it)
//                stack.clear()
//            }
//        }else{
//            numStack.push(Character.getNumericValue(i))
//        }
////        println(stack.toString())
////        println(numStack)
//    }
//
//    return numStack.joinToString("").toInt()
}