package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

private var n = 0
private var k = 0
private lateinit var board: MutableList<MutableList<Char>>

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        readLine().split(" ").map { it.toInt() }.let {
            n = it[0]
            k = it[1]
        }

        board = MutableList(n) {
            readLine().toMutableList()
        }

        // 1. 보드의 아래쪽 부터 합쳐질 수 있는 영역이 있는지 탐색한다.
        // 2. 합쳐질 수 있는 영역이 있다면 합치고 보드의 상태를 변경시킨다. (지워진 영역을 0으로 만들기)
        // 3. 0이 된 영역위로 1~9까지의 수가 있다면 아래로 내린다.
        // 4. 다시 1번 부터 반복한다.

        var flag = true
        while (flag){
            flag = false
            for (i in n - 1 downTo 0) {
                for (j in 0 until 10) {
                    if (board[i][j] == '0') continue

                    val removedSize = bfs(listOf(i, j))
                    if(removedSize >=k) flag = true
                }
            }

            if(flag.not()) break
            down()
        }

        board.forEach {
            println(it.joinToString(""))
        }
    }
}

fun mooyoMooyo(n: Int, k: Int, input: MutableList<String>): List<String> {
    val b = input.map {
        it.toMutableList()
    }.toMutableList()

    var flag = true
    while (flag) {
        flag = false

        for (i in 0 until n) {
            for (j in 0 until 10) {
                if (b[i][j] == '0') continue

                val removedCount = testBfs(listOf(i, j), b, k, n)
                if (removedCount >= k) {
                    flag = true
                }
            }
        }

        if(flag.not()){
            break
        }

        testDown(b, n)
    }


    return b.map {
        println(it.joinToString(""))
        it.joinToString("")
    }
}

private fun testBfs(startPosition: List<Int>, b: MutableList<MutableList<Char>>, k: Int, n: Int): Int {

    val needVisit = mutableSetOf<List<Int>>()
    needVisit.add(startPosition)

    val removed = mutableListOf<List<Int>>()

    while (needVisit.isNotEmpty()) {
        val pop = needVisit.first().also { needVisit.remove(it) }
        removed.add(pop)

        for (i in 0..3) {
            val x = pop[0]
            val y = pop[1]
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until n && ny in 0 until 10) {
                if (listOf(nx, ny) !in removed && b[x][y] == b[nx][ny]) {
                    needVisit.add(listOf(nx, ny))
                }
            }
        }
    }



    if (removed.size >= k) {
        removed.forEach { (x, y) ->
            b[x][y] = '0'
        }
    }
    return removed.size
}

private fun testDown(b: MutableList<MutableList<Char>>, n: Int) {
    for (i in 0 until 10) {
        val temp = mutableListOf<Char>()
        for (j in 0 until n) {
            if (b[j][i] != '0') temp.add(b[j][i])
        }

        for (j in 0 until n - temp.size) {
            b[j][i] = '0'
        }

        for (j in n - temp.size until n) {
            b[j][i] = temp.first().also { temp.remove(it) }
        }
    }
}


private fun down() {
    for (i in 0 until 10) {
        val temp = mutableListOf<Char>()
        for (j in 0 until n) {
            if (board[j][i] != '0') temp.add(board[j][i])
        }

        for (j in 0 until n - temp.size) {
            board[j][i] = '0'
        }

        for (j in n - temp.size until n) {
            board[j][i] = temp.first().also { temp.remove(it) }
        }
    }
}

private fun bfs(startPosition: List<Int>): Int {

    val needVisit = mutableSetOf<List<Int>>()
    needVisit.add(startPosition)

    val removed = mutableListOf<List<Int>>()

    while (needVisit.isNotEmpty()) {
        val pop = needVisit.first().also { needVisit.remove(it) }
        removed.add(pop)

        for (i in 0..3) {
            val x = pop[0]
            val y = pop[1]
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until n && ny in 0 until 10) {
                if (listOf(nx, ny) !in removed && board[x][y] == board[nx][ny]) {
                    needVisit.add(listOf(nx, ny))
                }
            }
        }
    }

    if (removed.size >= k) {
        removed.forEach { (x, y) ->
            board[x][y] = '0'
        }
    }
    return removed.size
}