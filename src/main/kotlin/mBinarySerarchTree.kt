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
        var parentsOfCurrent = current

        while (true) {
            when {
                data == current?.data -> break
                data < current?.data ?: break -> {
                    parentsOfCurrent = current
                    current = current.left
                }
                data > current.data -> {
                    parentsOfCurrent = current
                    current = current.right
                }
                else -> {
                    throw Exception("데이터가 없습니다.")
                }
            }
        }

        // 트리 재구성하기
        when {
            //leaf 노드인 경우
            current?.left == null && current?.right == null -> {

                if (data < parentsOfCurrent?.data ?: return) {
                    parentsOfCurrent.left = null
                }
                parentsOfCurrent.right = null
                return
            }

            // 왼쪽 자식만 있는 노드를 삭제하는 경우
            current.left != null && current.right == null -> {
                if (data < parentsOfCurrent?.data ?: return) {
                    parentsOfCurrent.left = current.left
                }
                return
            }

            //오른쪽 자식만 있는 노드를 삭제하는 경우
            current.left == null && current.right != null -> {
                println()
                if (data < parentsOfCurrent?.data ?: return) {
                    parentsOfCurrent.left = current.right
                }
                return
            }

            //자식이 두개 있는 노드를 삭제하는 경우
            else -> {
                var changed: Node? = null
                var parentsOfChanged: Node? = null

                println("현재 삭제할 노드의 부모 : ${parentsOfCurrent?.data}")
                println("현재 삭제할 노드 : ${current?.data}")
                if (data < parentsOfCurrent?.data ?: return) {
                    print(" 자식이 두개 있는 노드를 삭제하는 경우 - 왼쪽 자식")
                    changed = current.right
                    parentsOfChanged = current.right
                } else {
                    print(" 자식이 두개 있는 노드를 삭제하는 경우 - 오른쪽 자식")
                    changed = current.left
                    parentsOfChanged = current.left
                }

                while (changed?.left != null) {
                    parentsOfChanged = changed
                    changed = changed.left
                }

                if (changed?.right != null) {
                    parentsOfChanged?.left = changed.right
                } else {
                    parentsOfChanged?.left = null
                }

                parentsOfCurrent.left = changed
                changed.apply {
                    this?.left = current.left
                    this?.right = current.right
                }

            }
        }
    }

    class Node(val data: Int) {
        var right: Node? = null
        var left: Node? = null
    }
}