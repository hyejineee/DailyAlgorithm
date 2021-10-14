package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Node(val data: String) {
    var left: Node? = null
    var right: Node? = null
}

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()

        val m = mutableMapOf<Char, List<Char>>()
        (0 until n).forEach {
            val (data, left, right) = readLine().split(" ").map { it.toCharArray()[0] }
            m.put(data, listOf(left, right))

        }

        preOrder('A', m['A']!!.first(), m['A']!!.last(), m)
        println()
        inOrder('A', m['A']!!.first(), m['A']!!.last(), m)
        println()
        postOrder('A', m['A']!!.first(), m['A']!!.last(), m)


        bw.flush()
        bw.close()
    }
}

fun preOrder(data: Char, left: Char, right: Char, tree: MutableMap<Char, List<Char>>) {
    if (data == '.') return

    print(data)
    if (left != '.')
        preOrder(left, tree[left]!!.first(), tree[left]!!.last(), tree)
    if (right != '.')
        preOrder(right, tree[right]!!.first(), tree[right]!!.last(), tree)
}

fun inOrder(data: Char, left: Char, right: Char, tree: MutableMap<Char, List<Char>>) {
    if (data == '.') return

    if (left != '.')
        inOrder(left, tree[left]!!.first(), tree[left]!!.last(), tree)

    print(data)

    if (right != '.')
        inOrder(right, tree[right]!!.first(), tree[right]!!.last(), tree)
}

fun postOrder(data: Char, left: Char, right: Char, tree: MutableMap<Char, List<Char>>) {
    if (data == '.') return

    if (left != '.')
        postOrder(left, tree[left]!!.first(), tree[left]!!.last(), tree)

    if (right != '.')
        postOrder(right, tree[right]!!.first(), tree[right]!!.last(), tree)

    print(data)
}




