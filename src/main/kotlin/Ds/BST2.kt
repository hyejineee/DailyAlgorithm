package Ds

fun main() {
    val tree = BST2(TreeNode(21))

    println("==========insert============")
    tree.insert(15)
    tree.insert(28)
    tree.insert(25)
    tree.insert(32)

    tree.printTree()

    println("==========find============")
    println("32 in tree is ${tree.find(32)}")

    println("==========find with parent ============")
    println("patent of 28 ${tree.findWithParent(28).first?.value}")

    println("========== delete when no child ============")
    tree.delete(15)
    tree.printTree()
    tree.insert(15)

    println("========== delete when one child ============")
    tree.insert(14)
    tree.delete(15)
    tree.printTree()

    tree.delete(14)
    tree.insert(15)


    println("========== delete when two child case1 ============")

    tree.insert(29)
    tree.delete(28)
    tree.printTree()
    tree.insert(28)


    println("========== delete when two child case2 ============")

    tree.insert(30)
    tree.delete(28)
    tree.printTree()

    println("========== pre order ============")
    tree.preOrder()

    println("========== in order ============")
    tree.inOrder()

    println("========== post order ============")
    tree.postOrder()


}

class BST2(private val head: TreeNode) {
    fun printTree(current: TreeNode? = head) {
        current ?: return

        println("current : {${current.value}},  left : ${current.left?.value}, right : ${current.right?.value}")

        printTree(current.left)
        printTree(current.right)
    }

    fun preOrder() = preOrder(head)

    fun inOrder() = inOrder(head)

    fun postOrder() = postOrder(head)

    private fun postOrder(current: TreeNode?) {
        current ?: return

        postOrder(current.left)
        postOrder(current.right)
        println(current.value)
    }

    private fun inOrder(current: TreeNode?) {
        current ?: return
        inOrder(current.left)
        println(current.value)
        inOrder(current.right)
    }

    private fun preOrder(current: TreeNode?) {
        current ?: return

        println(current.value)

        preOrder(current.left)
        preOrder(current.right)
    }

    fun insert(data: Int) {
        val newNode = TreeNode(data)
        insert(head, newNode)
    }

    fun find(data: Int) = find(head, data)

    fun findWithParent(data: Int) = findWithParentNode(head, head, data)

    fun delete(data: Int): Boolean {

        val (parent, deleted) = findWithParent(data)

        deleted ?: return false
        parent ?: return false

        // 1. 삭제할 노드의 자식이 없는 경우
        if (deleted.right == null && deleted.left == null) {
            if (parent.value > deleted.value) {
                parent.left = null
            } else {
                parent.right = null
            }
            return true
        }

        // 2. 삭제할 노드의 자식이 1개 있는 경우
        if (deleted.right != null && deleted.left == null || deleted.left != null && deleted.right == null) {
            val child = if (deleted.right != null) deleted.right else deleted.left

            if (parent.value > deleted.value) {
                parent.left = child
            } else {
                parent.right = child
            }
            return true
        }

        // 3. 삭제할 노드의 자식이 2개 있는 경우
        if (deleted.right != null && deleted.left != null) {

            val (parentOfMinNode, minNode) = findMinValueNode(deleted, deleted.right)

            minNode ?: return false
            parentOfMinNode ?: return false

            if (minNode.right == null) {
                parentOfMinNode.left = null
            } else {
                parentOfMinNode.left = minNode.right
            }

            if (parent.value < deleted.value) {
                parent.right = minNode
            } else {
                parent.left = minNode
            }

            minNode.left = deleted.left
            minNode.right = deleted.right


        }

        return true

    }

    private fun findMinValueNode(parent: TreeNode, current: TreeNode?): Pair<TreeNode?, TreeNode?> {

        current ?: return Pair(null, null)

        if (current.left == null) {
            return Pair(parent, current)
        }

        return findMinValueNode(current, current.left)

    }

    private fun findWithParentNode(parent: TreeNode, current: TreeNode?, target: Int): Pair<TreeNode?, TreeNode?> {
        current ?: return Pair(null, null)

        if (current.value == target) {
            return Pair(parent, current)
        }

        val next = if (current.value > target) {
            current.left
        } else {
            current.right
        }

        return findWithParentNode(current, next, target)
    }


    private fun find(current: TreeNode?, target: Int): Boolean {
        current ?: return false

        if (current.value == target) {
            return true
        }

        val next = if (current.value > target) {
            current.left
        } else {
            current.right
        }

        return find(next, target)
    }

    private fun insert(current: TreeNode?, newNode: TreeNode) {
        current ?: return

        if (newNode.value < current.value) {
            //왼쪽노드로 설정
            current.left ?: run {
                current.left = newNode
                return
            }

            insert(current.left, newNode)
        } else {
            //오른쪽 노드로 설정
            current.right ?: kotlin.run {
                current.right = newNode
                return
            }
            insert(current.right, newNode)
        }
    }

}