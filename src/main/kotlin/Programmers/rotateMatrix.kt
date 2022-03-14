package Programmers

import Problems.counting
import org.junit.Test

fun rotateMatrixToLeft(arr : Array<IntArray>, r:Int, c:Int): Array<IntArray> {
    val new = Array(c){
        IntArray(r)
    }

    for(i in r-1 downTo 0){
        for (j in c-1 downTo 0){
            new[(c-1) -j][i] = arr[i][j]
        }
    }
    return new
}

fun rotateMatrixToRight(arr : Array<IntArray>, r:Int, c:Int): Array<IntArray> {
    val new = Array(c){
        IntArray(r)
    }

    for(i in 0 until r){
        for (j in 0 until c){
            new[j][(c-1)-i +1] = arr[i][j]
        }
    }

    new.forEach {
        println(it.asList())
    }
    return new
}