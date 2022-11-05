package Programmers.y2022._1105

import java.util.LinkedList
import java.util.Queue
import javax.xml.stream.events.Characters

class Winter {

    fun solution1(str: String): String {
        var result = str
        for (i in 97..122) {
            val c = i.toChar()
            val reg = "${c}{2,}".toRegex()
            result = result.replace(reg, "${c}*")
        }
        return result
    }

    fun solution2(n: Int, student: IntArray, point: IntArray): Int {
        val half = n / 2
        var dominant = List(half) { it + 1 }

        val record = mutableMapOf<Int, Int>()
        for (i in 1..n) {
            record[i] = 0
        }

        var count = 0
        student.forEachIndexed { index, s ->
            record[s] = record[s]?.plus(point[index]) ?: 1
            val arr = record.toList().sortedByDescending { it.second }
            val d = arr.subList(0, half).map { it.first }

            if (!d.containsAll(dominant)) {
                dominant = d
                count++
            }
        }

        return count
    }

    fun solution3(worldMap: Array<String>): Int {
        val dx = intArrayOf(-1, 1, 0, 0, -1, -1, 1, 1)
        val dy = intArrayOf(0, 0, -1, 1, -1, 1, -1, 1)
        val m = worldMap.size
        val n = worldMap[0].length

        val record = Array(m) { Array(n) { 0 } }

        val needVisit: Queue<Triple<IntArray, Char, Int>> = LinkedList()
        needVisit.offer(Triple(intArrayOf(0, 0), 'r', 90))
        record[0][0] = 1

        while (needVisit.isNotEmpty()) {
            val (p, dir, deg) = needVisit.poll()
            val (x, y) = p

            for (i in dx.indices) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1) continue;
                if (worldMap[nx][ny] == 'X') continue
                if(isDanger(dir, deg, worldMap, p)) continue

                val nDir = if(i in arrayOf(5,3,7)) 'r' else if(i in arrayOf(4,2,6)) 'l' else if(i == 0) 'u' else 'd'
                val nDeg = if(i in arrayOf(6,7)) 135 else if(i in arrayOf(4,5)) 45 else 90

                if(record[nx][ny] == 0){
                    needVisit.offer(Triple(intArrayOf(nx, ny), nDir, nDeg))
                    record[nx][ny] = record[x][y] +1
                }
            }
        }

        return record[m-1][n-1] -1
    }

    fun isDanger(dir: Char, deg: Int, map: Array<String>, current: IntArray): Boolean {
        if (deg == 90) return false

        val m = map.size
        val n = map[0].length

        val dx = if (deg == 45) intArrayOf(-1, 0) else intArrayOf(1, 0)
        val dy = if (dir == 'r') intArrayOf(0, 1) else intArrayOf(0, -1)

        for (i in 0 until 2) {
            val nx = current[0] + dx[i]
            val ny = current[1] + dy[i]

            if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1) continue;
            if(map[nx][ny] == 'X') return true
        }

        return false
    }
}