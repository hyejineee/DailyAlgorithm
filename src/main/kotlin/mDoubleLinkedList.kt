class mDoubleLinkedList(head: String) {
    private var head = Node(head)
    private var tail: Node = this.head

    fun add(data: String) {

        val newNode = Node(data)

        if (head.data == tail.data) {
            newNode.prev = head
            tail = newNode
            head.next = newNode
            return
        }

        tail.next = newNode
        newNode.prev = tail
        tail = newNode
    }

    fun addBeforeAt(index: Int, data: String) {
        val newNode = Node(data)
        var currentNode = head
        var currentIndex = 0

        if (index == 0) {
            newNode.next = head
            head.prev = newNode
            head = newNode
            return
        }

        while (true) {
            if (currentIndex == index) {

                currentNode.prev?.next = newNode

                newNode.prev = currentNode.prev
                newNode.next = currentNode

                currentNode.prev = newNode
                break
            }

            currentIndex++
            currentNode = currentNode.next ?: break
        }
    }

    fun addAfterAt(index: Int, data: String) {
        val newNode = Node(data)

        var currentNode = head
        var currentIndex = 0

        while (true) {
            if (currentIndex == index) {
                currentNode.next?.prev = newNode

                newNode.prev = currentNode
                newNode.next = currentNode.next

                currentNode.next = newNode

                if (currentNode.data == tail.data) {
                    tail = newNode
                    break
                }
            }
            currentIndex++
            currentNode = currentNode.next ?: break
        }
    }

    fun deleteAt(index: Int) {

        var currentNode = head
        var currentIndex = 0

        if (index == 0) {
            head.next?.prev = null
            head = head.next ?: throw Exception()
            return
        }

        while (true) {
            if (currentIndex == index) {

                if (currentNode.next == null) {
                    currentNode.prev?.next = null
                    tail = currentNode.prev!!
                    break
                }

                currentNode.prev?.next = currentNode.next
                currentNode.next?.prev = currentNode.prev

                break
            }

            currentIndex++
            currentNode = currentNode.next ?: break
        }

    }

    fun all(): List<String> {
        var currentNode = head
        val list = mutableListOf<String>()
        while (true) {
            list.add(currentNode.data)
            currentNode = currentNode.next ?: break
        }

        return list.toList()
    }

    class Node(val data: String) {
        var next: Node? = null
        var prev: Node? = null
    }
}