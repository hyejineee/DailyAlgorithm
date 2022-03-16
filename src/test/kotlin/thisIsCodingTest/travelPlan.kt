package thisIsCodingTest

fun travelPlan(connectedInfo: Array<IntArray>, travelPlan: IntArray, n: Int): String {
    val parents = IntArray(n+1){it}

    for(i in 0 until n){
        for (j in 0 until n){
            if(connectedInfo[i][j] ==1){
                union(i+1, j+1, parents)
            }
        }
    }
    val result = travelPlan.map { parents[it] }.toSet()

    return if(result.size > 1) "NO" else "YES"
}

private fun findParent(node:Int, parent:IntArray): Int {
    if(parent[node] != node){
        parent[node] = findParent(parent[node], parent)
    }
    return parent[node]
}

private fun union(n1:Int, n2:Int, parent: IntArray){
    val p1 = findParent(n1, parent)
    val p2 = findParent(n2, parent)

    if(p1 > p2){
        parent[p1] = p2
    }else{
        parent[p2] = p1
    }
}