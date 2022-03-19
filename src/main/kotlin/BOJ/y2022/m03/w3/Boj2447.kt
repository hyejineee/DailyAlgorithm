package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val result = printStar(n, mutableListOf("***","* *", "***"))
    result.forEach {
        println(it)
    }
    Unit
}

private fun printStar(n: Int, list:MutableList<String>): MutableList<String> {

    val out = mutableListOf<String>()
    if(n ==3){
        return list
    }else{
        for(i in list){
            out.add(i.repeat(3))
        }

        for (i in list){
            out.add(i + " ".repeat(list.size)+i)
        }

        for(i in list){
            out.add(i.repeat(3))
        }

        return printStar(n/3, out)
    }
}

