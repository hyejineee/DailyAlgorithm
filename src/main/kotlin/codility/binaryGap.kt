package codility

import java.util.*
import kotlin.math.max

fun binaryGap(N:Int):Int{
    val binary = Integer.toBinaryString(N)
    var maxCount = 0
    var count = 0

    binary.forEach {
        if(it =='1'){
            maxCount = max(count, maxCount)
            count = 0
        }else{
            count++
        }
    }

    return maxCount
}