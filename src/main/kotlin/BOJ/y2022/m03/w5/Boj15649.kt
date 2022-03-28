package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    combination(m, m, BooleanArray(n+1), mutableListOf(), n)
}

private fun combination(level:Int, curLevel:Int, visited:BooleanArray, arr:MutableList<Int>, range:Int){
    if(curLevel == 0){
        arr.forEach { print("$it ") }
        println()
        return
    }else{
        for (i in  1..range){
            if(visited[i].not()){
                visited[i] = true
                arr.add(i)
                combination(level, curLevel-1, visited, arr, range)
                arr.removeLast()
                visited[i] = false
            }
        }
    }
}