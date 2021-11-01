package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val tc = readLine().toInt()

        (1..tc).forEach {
            val (m,n,k) = readLine().split(" ").map { it.toInt() }

            val farm = MutableList(n){
                MutableList(m){false}
            }

            val cabbagePositions = mutableListOf<Pair<Int, Int>>()

            (1.. k).forEach {
                val (x, y) = readLine().split(" ").map { it.toInt() }
                cabbagePositions.add(Pair(y,x))
            }

            var count =0

            for(i in 0 until n){
                for(j in 0 until m){
                    if(farm[i][j]) continue

                    if(Pair(i,j) in cabbagePositions){
                        count += bfs(Pair(i,j), farm, cabbagePositions)
                    }

                }
            }

            println(count)

        }
    }
}

private fun bfs(startPosition:Pair<Int, Int>, farm : MutableList<MutableList<Boolean>>, cabbagePositions : List<Pair<Int, Int>>):Int{
    val needVisit = LinkedList<Pair<Int,Int>>()
    var visited =0
    needVisit.add(startPosition)

    while (needVisit.isNotEmpty()){
        val pop = needVisit.pollFirst()

        if(pop in cabbagePositions && !farm[pop.first][pop.second]){
            farm[pop.first][pop.second] = true
            visited ++

            listOf(
                Pair(pop.first -1, pop.second),
                Pair(pop.first +1, pop.second),
                Pair(pop.first, pop.second-1),
                Pair(pop.first, pop.second + 1),
            ).forEach {
                if(it.first in 0 until farm.size && it.second in 0 until farm[0].size){
                    needVisit.add(it)
                }
            }
        }
    }
    return if(visited > 0) 1 else 0
}

