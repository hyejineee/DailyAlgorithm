package Programmers

fun linkIsland(n: Int, costs: Array<IntArray>): Int {
    val rank = Array(n) { 0 }
    val parent = Array(n) { it }

    val sorted = costs.sortedBy { it[2] }
    var answer = 0

    sorted.forEach { (n1, n2, c) ->
        val p1 = find(n1, parent)
        val p2 = find(n2, parent)

        if (p1 != p2) {
            union(p1, p2, parent, rank)
            answer += c
        }

    }

    return answer
}

private fun find(n:Int, parent:Array<Int>):Int{
    if(n != parent[n]){
        parent[n] = find(parent[n], parent)
    }
    return parent[n]!!
}

private fun union(p1:Int, p2:Int, parent:Array<Int>, rank:Array<Int>){
    val r1 = rank[p1]
    val r2 = rank[p2]

    if(r1 < r2){
        parent[p1] = p2
    }else if(r1 > r2){
        parent[p2] = p1
    }else{
        rank[p2] = r2+1
        parent[p1] = p2
    }
}