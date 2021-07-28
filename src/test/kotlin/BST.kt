data class Node(
    val value: Int,
    var left: Node? = null,
    var right: Node? = null
)

fun main() {
    val bst = BST(Node(21))

//    insertData(bst)
//
//    println(bst.search(32))
//    println(bst.search(19))
//
//    println(bst.delete(32))
//    bst.circuit()
//
//    println(bst.delete(28))
//    bst.circuit()

    println("-----")

    insertDataWithOut16(bst)
    bst.delete(14)
    bst.circuit()

    bst.clear()
    println("-----when right node is existed----------")
    insertData(bst)
    bst.delete(14)
    bst.circuit()

    bst.clear()
    println("-----when right node is existed----------")
    println()

    insertRightTestData(bst)
    bst.delete(28)
    bst.circuit()

    bst.clear()
    println("-----when right node is not existed----------")
    println()

    insertRightTestDataWithOut31(bst)
    bst.delete(28)
    bst.circuit()
}

fun insertData(bst: BST) {
    bst.insert(Node(14))
    bst.insert(Node(28))
    bst.insert(Node(11))
    bst.insert(Node(18))
    bst.insert(Node(25))
    bst.insert(Node(32))
    bst.insert(Node(15))
    bst.insert(Node(16))
    bst.insert(Node(19))
}

fun insertDataWithOut16(bst: BST) {
    bst.insert(Node(14))
    bst.insert(Node(28))
    bst.insert(Node(11))
    bst.insert(Node(18))
    bst.insert(Node(25))
    bst.insert(Node(32))
    bst.insert(Node(15))
    bst.insert(Node(19))
}

fun insertRightTestData(bst: BST) {
    bst.insert(Node(14))
    bst.insert(Node(28))
    bst.insert(Node(11))
    bst.insert(Node(18))
    bst.insert(Node(25))
    bst.insert(Node(32))
    bst.insert(Node(30))
    bst.insert(Node(33))
    bst.insert(Node(31))
}

fun insertRightTestDataWithOut31(bst: BST) {
    bst.insert(Node(14))
    bst.insert(Node(28))
    bst.insert(Node(11))
    bst.insert(Node(18))
    bst.insert(Node(25))
    bst.insert(Node(32))
    bst.insert(Node(30))
    bst.insert(Node(33))
}

class BST(private var head: Node) {

    fun clear() {
        head = Node(head.value, null, null)
    }

    fun insert(node: Node) {
        var current = head
        comparison(current, node)
    }

    fun search(value: Int): Boolean {
        var current = head
        return searchNode(current, value) != null
    }

    fun delete(value: Int): Boolean {
        val current = head
        val result = searchWithParent(current, current, Node(value))

        if (result.isEmpty()) {
            return false
        }

        val (parent, deleted) = result

        // 1. 삭제할 노드가 leaf노드인 경우
        if (deleted.left == null && deleted.right == null) {
            when {
                parent.value < deleted.value -> parent.right = null
                else -> parent.left = null
            }
            return true
        }

        // 2. 삭제할 노드의 자식 노드가 1개인 경우
        if (deleted.left == null || deleted.right == null) {
            val node = if (deleted.right == null) deleted.left else deleted.right
            when {
                parent.value < deleted.value -> parent.right = node
                else -> parent.left = node
            }
            return true
        }

        // 3. 삭제할 노드의 자식노드가 2개인 경우
        val (parentOfSelected, selected) = findMin(deleted.right!!, deleted.right!!)

        if (selected.right != null) {
            parentOfSelected.left = selected.right
        } else {
            parentOfSelected.left = null
        }

        when {
            parent.value < deleted.value -> parent.right = selected
            else -> parent.left = selected
        }
        selected.left = deleted.left
        selected.right = deleted.right

        return true
    }

    private fun findMin(parent: Node, current: Node): List<Node> {
        if (current.left == null) {
            return listOf(parent, current)
        }
        return findMin(current, current.left!!)
    }

    private fun searchWithParent(parent: Node = head, current: Node = head, target: Node): List<Node> {
        if (current.value == target.value) {
            return listOf(parent, current)
        }

        val next = when {
            current.value < target.value -> current.right ?: run {
                return emptyList()
            }
            else -> current.left ?: run {
                return emptyList()
            }
        }

        return searchWithParent(current, next, target)
    }

    private fun searchNode(current: Node, target: Int): Node? {
        if (current.value == target) {
            return current
        }

        var next: Node? = null

        next = when {
            current.value < target -> current.right ?: return null
            else -> current.left ?: return null
        }

        return searchNode(next, target)
    }

    fun circuit(parent: Node = head, current: Node? = head) {
        current ?: run {
            return
        }

        println("patent :${parent.value}, current : ${current.value}, left:${current.left?.value}. right:${current.right?.value}")

        circuit(current, current.left)
        circuit(current, current.right)
    }

    private fun comparison(current: Node, target: Node) {
        if (current.value < target.value) {

            current.right ?: run {
                current.right = target
                return
            }
            comparison(current.right!!, target)

        } else {

            current.left ?: run {
                current.left = target
                return
            }
            comparison(current.left!!, target)
        }
    }
}