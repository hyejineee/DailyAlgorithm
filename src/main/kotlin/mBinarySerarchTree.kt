class mBinarySerarchTree {
    private var root: Node? = null

    fun add(data: Int) {
        if (root == null) {
            root = Node(data)
            return
        }

        var current = root

        while (true) {
            if (data < current?.data ?: break) {

                if (current.left != null) {
                    current = current.left
                    continue
                }

                current.left = Node(data)
                break
            }

            if (current.right != null) {
                current = current.right
                continue
            }

            current.right = Node(data)
            break
        }
    }

    fun find(data: Int): Boolean {
        var current = root

        while (true) {
            if (current?.data == data) {
                return true
            }

            if (data < current?.data ?: break) {
                current = current.left
                continue
            }

            current = current.right
        }

        return false
    }

    fun delete(data: Int) {
        var current = root
        var parentsOfCurrent = root

        while (true) {
            //leaf 노드인 경우
            if (current?.left == null && current?.right == null) {
                if (data < parentsOfCurrent?.data ?: break) {
                    parentsOfCurrent.left = null
                }
                parentsOfCurrent.right = null
                return
            }

            // 자식이 1개 있는 노드를 삭제하는 경우
            if (current.left != null && current.right == null) {
                if (data < parentsOfCurrent?.data ?: break) {
                    parentsOfCurrent.left = current.left
                    return
                }

                parentsOfCurrent.right = current.right
                return
            }

            //자식이 2개 있는 노드를 삭제하는 경우
        }
    }

    class Node(val data: Int) {
        var right: Node? = null
        var left: Node? = null
    }
}