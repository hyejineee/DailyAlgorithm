package Programmers

import kotlin.math.ceil
import kotlin.math.round
import kotlin.math.sqrt

fun expectedDraw(n: Int, a: Int, b: Int): Int {

//    var start = 0
//    var end = n
//
//    while (start <= end) {
//        val mid = (start + end) / 2
//        println("a :$a, b:$b, start:$start, end:$end, mid:$mid")
//        val aa = if (a < b) a else b
//        val bb = if (a < b) b else a
//        if (aa <= mid && mid < bb) {
//            println(sqrt((end-start).toDouble()))
//            return round(sqrt((end - start).toDouble())).toInt()
//        }
//
//        if (aa <= mid && bb <= mid) {
//            end = mid
//        } else {
//            start = mid
//        }
//    }
//    return 0

    var count = 0
    var aa = a
    var bb =b
    while (true){
        count++
        aa = ceil(aa.toDouble()/2).toInt()
        bb = ceil(bb.toDouble()/2).toInt()

        if(aa==bb || a ==0 || a== 0){
            break
        }
    }
    return count

}