package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n, l, k) = readLine().split(" ").map { it.toInt() }
        val problems = mutableListOf<List<Int>>()

        var score = 0
        var count = 0

        for(i in (1..n)) {
            val (sub1, sub2) = readLine().split(" ").map { it.toInt() }
            if( !(sub1 > l && sub2 > l)) {
                problems.add(listOf(sub1, sub2))
            }
        }
        problems.sortWith(compareBy { it.last() })

        for((sub1, sub2) in problems){
            if( count == k) break
            if(sub2 <=l){
                score +=140
            }else if(sub1<=l){
                score +=100
            }
            count+=1
        }

        println(score)


        bw.flush()
        bw.close()
    }
}