package Ds


fun main() {
    val bst = BST(TreeNode(21))
    insertData(bst)

    println(bst.search(32))
    println(bst.search(19))

    bst.clear()
    println()
    println("-----자식이 2개인 노드 삭제하기1----------")
    println()

    insertDataWithOut16(bst)
    bst.delete(14)
    bst.circuit()

    bst.clear()
    println()
    println("-----자식이 2개인 노드 삭제하기2----------")
    println()

    insertData(bst)
    bst.delete(14)
    bst.circuit()

}

fun insertData(bst: BST) {
    bst.insert(TreeNode(14))
    bst.insert(TreeNode(28))
    bst.insert(TreeNode(11))
    bst.insert(TreeNode(18))
    bst.insert(TreeNode(25))
    bst.insert(TreeNode(32))
    bst.insert(TreeNode(15))
    bst.insert(TreeNode(16))
    bst.insert(TreeNode(19))
}

fun insertDataWithOut16(bst: BST) {
    bst.insert(TreeNode(14))
    bst.insert(TreeNode(28))
    bst.insert(TreeNode(11))
    bst.insert(TreeNode(18))
    bst.insert(TreeNode(25))
    bst.insert(TreeNode(32))
    bst.insert(TreeNode(15))
    bst.insert(TreeNode(19))
}

fun insertRightTestData(bst: BST) {
    bst.insert(TreeNode(14))
    bst.insert(TreeNode(28))
    bst.insert(TreeNode(11))
    bst.insert(TreeNode(18))
    bst.insert(TreeNode(25))
    bst.insert(TreeNode(32))
    bst.insert(TreeNode(30))
    bst.insert(TreeNode(33))
    bst.insert(TreeNode(31))
}

fun insertRightTestDataWithOut31(bst: BST) {
    bst.insert(TreeNode(14))
    bst.insert(TreeNode(28))
    bst.insert(TreeNode(11))
    bst.insert(TreeNode(18))
    bst.insert(TreeNode(25))
    bst.insert(TreeNode(32))
    bst.insert(TreeNode(30))
    bst.insert(TreeNode(33))
}

class BST(private var head: TreeNode) {

    fun clear() {
        head = TreeNode(head.value, null, null)
    }

    fun insert(node: TreeNode) {
        val current = head
        insertNode(current, node)
    }

    fun search(value: Int): Boolean {
        val current = head
        return searchTreeNode(current, value) != null
    }

    fun delete(value: Int): Boolean {
        val current = head
        val result = searchWithParent(current, current, TreeNode(value))

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

    private fun findMin(parent: TreeNode, current: TreeNode): List<TreeNode> {
        if (current.left == null) {
            return listOf(parent, current)
        }
        return findMin(current, current.left!!)
    }

    private fun searchWithParent(parent: TreeNode = head, current: TreeNode = head, target: TreeNode): List<TreeNode> {
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

    private fun searchTreeNode(current: TreeNode, target: Int): TreeNode? {
        if (current.value == target) {
            return current
        }

        var next: TreeNode? = null

        next = when {
            current.value < target -> current.right ?: return null
            else -> current.left ?: return null
        }

        return searchTreeNode(next, target)
    }

    fun circuit(parent: TreeNode = head, current: TreeNode? = head) {
        current ?: run {
            return
        }

        println("patent :${parent.value}, current : ${current.value}, left:${current.left?.value}. right:${current.right?.value}")

        circuit(current, current.left)
        circuit(current, current.right)
    }

    private fun insertNode(current: TreeNode, target: TreeNode) {
        if (current.value < target.value) {

            current.right ?: run {
                current.right = target
                return
            }
            insertNode(current.right!!, target)

        } else {

            current.left ?: run {
                current.left = target
                return
            }
            insertNode(current.left!!, target)
        }
    }
}