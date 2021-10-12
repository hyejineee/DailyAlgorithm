class mLinkedList(data: String) {
    private var head: Node? = Node(data, null)

    fun add(data: String) {
        val newNode = Node(data, null)
        var node: Node? = head

        while (node?.next != null) {
            node = node.next
        }

        node?.next = newNode
    }

    fun printAll() {
        var node: Node? = head
        while (node?.next != null) {
            println(node.data)
            node = node.next
        }
    }

    fun get(data: String): String {
        var node: Node? = head

        while (node != null) {

            if (node.data == data) {
                println("get : ${node.data}")
                return node.data
            }
            node = node.next
        }

        return node?.data ?: "데이터가 없습니다."
    }

    fun delete(data: String) {
        if (data == head?.data && head?.next != null) {
            this.head = head?.next
            return
        }
        var node = head
        while (node?.next != null) {

            if (node.next?.data == data) {
                node.next = node.next?.next
                return
            }
            node = node.next
        }
    }
}