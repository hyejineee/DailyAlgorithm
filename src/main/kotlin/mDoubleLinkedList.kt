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