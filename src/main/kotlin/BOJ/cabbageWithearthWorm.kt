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
            val (m, n, k) = readLine().split(" ").map { it.toInt() }
            val cabbagePositions = mutableListOf<List<Int>>()
            val farm = MutableList(n){
                MutableList(m){false}
            }

            (1..k).forEach {
                val (x, y) = readLine().split(" ").map { it.toInt() }
                cabbagePositions.add(listOf(y,x))
            }

            var wormCount = 0
            for(i in 0 until n){
                for(j in 0 until m){
                    if(farm[i][j]) continue

                    wormCount += bfs(listOf(i,j), farm, cabbagePositions)
                }
            }

            bw.write("$wormCount\n")

        }

        bw.flush()
        bw.close()

    }
}

private fun bfs(startPosition:List<Int>, farm:MutableList<MutableList<Boolean>>, cabbagePositions:MutableList<List<Int>>): Int {
    val needVisit = LinkedList<List<Int>>()
    var visited = false

    needVisit.add(startPosition)

    while (needVisit.isNotEmpty()){
        val pop = needVisit.pollFirst()

        if(pop in cabbagePositions && !farm[pop.first()][pop.last()] ){

            farm[pop.first()][pop.last()] = true
            visited = true

            val adjacent = listOf(
                listOf(pop.first()-1, pop.last()), //상
                listOf(pop.first()+1, pop.last()), //하
                listOf(pop.first(), pop.last()-1), //좌
                listOf(pop.first(), pop.last()+1), //우
            )

            adjacent.forEach { (y, x) ->
                if(x in 0 until farm[0].size && y in 0 until farm.size){
                    needVisit.add(listOf(y,x))
                }
            }
        }
    }

    return if(visited) 1 else 0
}

