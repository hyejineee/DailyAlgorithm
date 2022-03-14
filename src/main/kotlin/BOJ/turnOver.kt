package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val s = readLine().toCharArray()

        var count0 = 0
        var count1 = 0
        var current = s.first()

        if(current == '0') count0 +=1 else count1+=1

        for(i in 1 until s.size){
            if(s[i] == current) continue
            current = s[i]
            if(current == '0') count0 +=1 else count1+=1
        }

        println(minOf(count0, count1))
    }
}

