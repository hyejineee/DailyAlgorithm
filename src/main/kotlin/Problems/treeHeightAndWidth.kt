package Problems

import kotlin.math.min

data class Node(
    val value: Int,
    var level: Int = 1,
    var parent: Int? = null,
    var left: Node? = null,
    var right: Node? = null
)

fun treeHeightAndWidth(tree: Map<Int, List<Int>>): List<Int> {

    var nodeTree = mutableMapOf<Int, Node?>()
    var minMaxOfLevel = mutableMapOf<Int, MutableList<Int>>()

    for (i in tree) {
        nodeTree[i.key] = null
        minMaxOfLevel[i.key] = mutableListOf(tree.size, 0)
    }

    for (i in tree) {

        val newNode = Node(
            value = i.key,
            left = Node(value = i.value[0], parent = i.key),
            right = Node(value = i.value[1], parent = i.key)
        )

        val parent = nodeTree[nodeTree[i.key]?.parent]

        nodeTree[i.key] = nodeTree[i.key]?.copy(
            left = Node(value = i.value[0]),
            right = Node(value = i.value[1]),
            level = parent?.level?.plus(1) ?: 1
        ) ?: newNode


        if (i.value[0] != -1) {
            nodeTree[newNode.left?.value!!] = newNode.left
        }

        if (i.value[1] != -1) {
            nodeTree[newNode.right?.value!!] = newNode.right
        }

    }

    inOrder(nodeTree[1]!!, nodeTree, minMaxOfLevel)

    val result = minMaxOfLevel
        .filter { it.value[0] < it.value[1] }
        .maxByOrNull {
            it.value[1] - it.value[0]
        }


    if (result != null) {
        return listOf(result.key, result.value[1] - result.value[0] + 1)
    }
    return emptyList()
}

var x = 1
fun inOrder(current: Node, tree: Map<Int, Node?>, minMaxOfLevel: Map<Int, MutableList<Int>>) {

    if (current.left?.value != -1) {
        inOrder(tree[current.left!!.value]!!, tree, minMaxOfLevel)
    }

    minMaxOfLevel[current.level]?.apply {
        set(0, min(x, this[0]))
        set(1, kotlin.math.max(x, this[1]))
    }
    x++

    if (current.right?.value != -1) {
        inOrder(tree[current.right!!.value]!!, tree, minMaxOfLevel)
    }
}