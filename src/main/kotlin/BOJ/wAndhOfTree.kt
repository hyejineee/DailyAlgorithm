package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Node2250(val data: Int) {
    var parent: Int = -1
    var left: Int = -1
    var right: Int = -1
}

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()

        val tree = mutableMapOf<Int, Node2250>()
        val colList = mutableMapOf<Int, MutableList<Int>>()

        (1..n).forEach {
            tree.put(it, Node2250(it))
        }

        (0 until n).forEach {
            val (data, l, r) = readLine().split(" ").map { it.toInt() }
            tree[data]?.apply {
                if (l != -1) {
                    left = l
                    tree[l]?.parent = data
                }

                if (r != -1) {
                    right = r
                    tree[r]?.parent = data
                }
            }
        }

        var root = 0
        for (i in tree) {
            if (i.value.parent == -1) {
                root = i.value.data
            }
        }

        inOrderWithColumn(1, root, tree, colList)

        val k = colList.toSortedMap().maxByOrNull { it.value.last() - it.value.first() + 1 }?.key

        bw.write("$k ${(colList[k]?.last()!!) - colList[k]?.first()!! + 1}")

        bw.flush()
        bw.close()
    }
}


var col = 1

fun inOrderWithColumn(
    level: Int,
    curNode: Int,
    tree: MutableMap<Int, Node2250>,
    colList: MutableMap<Int, MutableList<Int>>
) {

    val l = tree[curNode]?.left ?: -1
    val r = tree[curNode]?.right ?: -1

    if (l != -1)
        inOrderWithColumn(level + 1, l, tree, colList)

    colList[level]?.add(col) ?: run { colList[level] = mutableListOf(col) }
    col += 1

    if (r != -1)
        inOrderWithColumn(level + 1, r, tree, colList)
}




