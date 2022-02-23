package thisIsCodingTest

import Programmers.count

class Meterialization {
    fun UDLR(n: Int, plan: String): IntArray {
        val board = Array(n + 2) { IntArray(n + 2) { 0 } }

        var i = 1
        var j = 1
        val plans = plan.split(" ")

        for (p in plans) {
            if (p == "R") {
                if (j + 1 > n) continue
                j += 1

                continue
            }

            if (p == "U") {
                if (i - 1 < 1) continue
                i -= 1
                continue
            }

            if (p == "L") {
                if (j - 1 < 0) continue
                j -= 1
                continue
            }

            if (p == "D") {
                if (i + 1 > n) continue
                i += 1
                continue
            }
        }
        return intArrayOf(i, j)
    }

    fun time(n: Int): Int {
        var count = 0
        for (i in 0..n) {
            for (j in 0 until 60) {
                for (k in 0 until 60) {
                    if ("$i $j $k".contains("3")) count++
                }
            }
        }
        return count
    }

    fun royalKnight(position: String): Int {

        val candidates = arrayOf(
            intArrayOf(2, -1),
            intArrayOf(2, 1),
            intArrayOf(-2, -1),
            intArrayOf(-2, 1),
            intArrayOf(-1, -2),
            intArrayOf(-1, 2),
            intArrayOf(1, -2),
            intArrayOf(1, 2),
        )

        val j = position.toCharArray()[0].toInt() - 96
        val i = Character.getNumericValue(position.toCharArray()[1])
        var count = 0
        candidates.forEach {
            val (ni, nj) = it
            if ((i + ni in 1..8) && (j + nj in 1..8)) count++
        }

        return count
    }

    fun gameDevelop(position: IntArray, dir: Int, map: Array<IntArray>): Int {

        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, 1, 0, -1)
        val n = map.size
        val m = map[0].size

        var (cx, cy) = position
        var cd = dir
        var count = 1
        var turnTime = 0

        val available = Array(map.size) { i ->
            BooleanArray(map[0].size) { j ->
                map[i][j] != 1
            }
        }

        available[cx][cy] = false

        while (true) {
            cd = turnLeft(cd)

            val nx = cx + dx[cd]
            val ny = cy + dy[cd]

            //다음 칸 = 갈 수 있는 곳
            if(nx in 0 until n && ny in 0 until m && available[nx][ny]){
                // 이동
                cx = nx
                cy = ny
                available[cx][cy] = false
                turnTime = 0
                count++
            }else{
                turnTime +=1
            }

            if(turnTime == 4){
                val nx = cx - dx[cd]
                val ny = cy - dy[cd]

                if(available[nx][ny]) {
                    cx = nx
                    cy = ny
                }
                else{
                    break
                }

                turnTime = 0
            }
        }
        return count
    }

    private fun turnLeft(cd: Int): Int = when (cd) {
        0 -> 3
        else -> cd - 1
    }

}