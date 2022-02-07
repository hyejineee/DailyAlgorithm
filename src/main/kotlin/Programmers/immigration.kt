package Programmers

import kotlin.math.min

fun immigration(n:Int, times:IntArray):Long{

    var start:Long = 1
    var end:Long = ((times.maxBy { it } ?: 0).toLong() * n)
    var answer:Long = end

    while(start <=end){
        val mid:Long = (start + end) /2

        val doneCount = times.fold(0L){ acc, i ->
            acc.plus((mid/i))
        }

        println("start:$start, mid:$mid, end:$end, doneCount:$doneCount, answer:$answer")

        if(doneCount >= n){
            answer = min(answer, mid)
            end = mid -1
        }else{
            start = mid + 1
        }
    }

    return answer
}