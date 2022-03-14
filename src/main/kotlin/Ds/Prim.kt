package Ds

import java.util.*


fun main() {
    val edges = listOf(
        Triple(7, 'A', 'B'),
        Triple(5, 'A', 'D'),
        Triple(9, 'D', 'B'),
        Triple(8, 'B', 'C'),
        Triple(7, 'B', 'F'),
        Triple(7, 'D', 'F'),
        Triple(5, 'C', 'F'),
        Triple(6, 'D', 'E'),
        Triple(8, 'E', 'F'),
        Triple(11, 'E', 'G'),
        Triple(9, 'G', 'F')
    )
    prim('A', edges)
    p('A', edges)
}

/**
 *  프림 복습
 *      - 최소신장트리를 찾기 위한 알고리즘
 *      - 크루스칼과 마찬가지로 탐욕 알고리즘에 기초함
 *      - 처음부터 간선을 정렬하지 않고 선택된 간선 중에서 가중치가 낮은 간선을 선택.
 * */

fun p(startNode: Char, edges: List<Triple<Int, Char, Char>>): MutableList<Triple<Int, Char, Char>> {

    // 인접합 간선을 저장하는 정보
    val adjacentEdges = mutableMapOf<Char, MutableList<Triple<Int, Char, Char>>>()

    for ((w, n1, n2) in edges) {
        adjacentEdges[n1]?.add(Triple(w, n1, n2)) ?: run { adjacentEdges[n1] = mutableListOf(Triple(w, n1, n2)) }
        adjacentEdges[n2]?.add(Triple(w, n2, n1)) ?: run { adjacentEdges[n2] = mutableListOf(Triple(w, n2, n1)) }
    }


    // 연결된 노드 집합
    val connectedNode = mutableListOf<Char>().apply {
        add(startNode)
    }

    // 방문해야 하는 간선 리스트
    val needVisit = TreeSet<Triple<Int, Char, Char>>(kotlin.Comparator { o1, o2 ->
        when {
            o1.first > o2.first -> -1
            o1.first < o2.first -> 1
            else -> 0
        }
    })

    adjacentEdges[startNode]!!.forEach {
        needVisit.add(it)
    }

    val mst = mutableListOf<Triple<Int, Char, Char>>()

    while (needVisit.isNotEmpty()) {
        val (w, n1, n2) = needVisit.pollFirst()

        if (n2 !in connectedNode) {
            connectedNode.add(n2)
            mst.add(Triple(w, n1, n2))

            for (e in adjacentEdges[n2]!!) {
                if (e.third !in connectedNode) {
                    needVisit.add(e)
                }
            }
        }

    }

    return mst
}

fun prim(startNode: Char, edges: List<Triple<Int, Char, Char>>): MutableList<Triple<Int, Char, Char>> {
    // 노드에 인접한 간선 정보를 저장
    val adjacentEdges = mutableMapOf<Char, MutableList<Triple<Int, Char, Char>>>()

    for ((w, n1, n2) in edges) {
        adjacentEdges[n1]?.add(Triple(w, n1, n2)) ?: run { adjacentEdges[n1] = mutableListOf(Triple(w, n1, n2)) }
        adjacentEdges[n2]?.add(Triple(w, n2, n1)) ?: run { adjacentEdges[n2] = mutableListOf(Triple(w, n2, n1)) }
    }

    val connectedNode = mutableListOf(startNode) //연결된 노드 정보를 저장.

    val edgeList = TreeSet<Triple<Int, Char, Char>>(kotlin.Comparator { o1, o2 ->       //간선 리스트를 저장.
        when {
            o1.first < o2.first -> -1
            o1.first > o2.first -> 1
            else -> 0
        }
    })

    adjacentEdges[startNode]?.forEach {
        edgeList.add(it)
    }

    val mst = mutableListOf<Triple<Int, Char, Char>>()

    while (edgeList.isNotEmpty()) {
        val (w, n1, n2) = edgeList.pollFirst()

        if (n2 !in connectedNode) {
            connectedNode.add(n2)
            mst.add(Triple(w, n1, n2))

            // 선택된 간선과 연결된 간선 정보를 간선 리스트에 저장.
            for (edge in adjacentEdges[n2]!!) {
                if (edge.third !in connectedNode) {
                    edgeList.add(edge)
                }
            }
        }

    }
    return mst
}


