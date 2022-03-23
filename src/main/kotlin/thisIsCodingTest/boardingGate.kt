package thisIsCodingTest

fun boardingGate(g: Int, p: Int, gs: IntArray): Int {
    val parent = IntArray(g+1){it}

    var count = 0
    for (i in 0 until p){
        val root = find(gs[i], parent)
        if(root == 0) break

        union(root, root-1, parent)
        count++
    }
    return count
}

private fun find(n: Int, parent: IntArray): Int {
    if (parent[n] != n) {
        parent[n] = find(parent[n], parent)
    }
    return parent[n]
}

private fun union(n1: Int, n2: Int, parent: IntArray) {
    val p1 = find(n1, parent)
    val p2 = find(n2, parent)

    if (p1 < p2) {
        parent[p2] = p1
    }else{
        parent[p1] = p2
    }
}