package thisIsCodingTest

class BFSDFS {

    fun freezeDrinks(board: Array<IntArray>): Int {
        val n = board.size
        val m = board[0].size

        val available = Array(n) { i ->
            BooleanArray(m) { j ->
                board[i][j] != 0
            }
        }

        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if(dfs(i,j,available)){
                    count++
                }
            }
        }
        return count
    }

    private fun dfs(i: Int, j: Int, available: Array<BooleanArray>): Boolean {
        val n = available.size
        val m = available[0].size

        if (((i in 0 until n ) && (j in 0 until m)).not()) return false

        if (available[i][j].not()) {
            available[i][j] = true

            dfs(i - 1, j, available)
            dfs(i + 1, j , available)
            dfs(i, j - 1, available)
            dfs(i, j+1, available)
            return true
        }
        return false
    }
}