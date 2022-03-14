package Programmers

import java.util.*

fun checkDistancing(places: Array<Array<String>>): IntArray = IntArray(5){ checkWaitingRoom(places[it])}

fun checkWaitingRoom(room: Array<String>): Int {
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if(room[i][j] =='O' || room[i][j] =='X') continue
            if(bfs(intArrayOf(i,j), room) == 0){
                return 0
            }
        }
    }
    return 1
}

private fun bfs(startPosition: IntArray, room: Array<String>):Int {
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)
    val q = LinkedList<IntArray>()
    val visited = Array(5) { BooleanArray(5) { false } }
    val distance = Array(5) { IntArray(5) { 0 } }

    q.add(startPosition)

    while (q.isNotEmpty()) {
        q.forEach { print(it.toList()) }
        println()

        visited.forEach { println(it.toList()) }
        distance.forEach { println(it.toList()) }

        val (x, y) = q.poll()
        visited[x][y] = true

        if(room[x][y]== 'P' && distance[x][y] <=1 && !intArrayOf(x,y).contentEquals(startPosition)){
            return 0
        }

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]


            if (nx !in 0 until 5 || ny !in 0 until 5) continue
            if (visited[nx][ny]) continue

            println("nx:$nx, ny:$ny")

            if ((room[nx][ny] == 'O' || room[nx][ny] == 'P') && visited[nx][ny].not()) {
                q.add(intArrayOf(nx, ny))

                distance[nx][ny] = distance[x][y] + 1
            }
        }
    }
    return 1
}
