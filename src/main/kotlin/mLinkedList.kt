class mLinkedList(data: String) {
    private var head: Node = Node(0, data, null)
    private var lastIndex = 0

    fun add(data: String) {
        val newNode = Node(lastIndex + 1, data, null)
        var node: Node? = head
        while (node?.next != null) {
            node = node.next
        }

        node?.next = newNode
        lastIndex++
    }

    fun printAll() {
        var node: Node? = head
        while (node != null) {
            println(node.data)
            node = node.next
        }
    }

    fun get(index: Int): String {


        return "name"
    }
}