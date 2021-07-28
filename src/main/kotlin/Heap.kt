fun main() {
    val heap = Heap(15)

    heap.insert(10)
    heap.insert(8)
    heap.insert(4)
    heap.insert(5)
    heap.insert(20)

    heap.printHeap()
}

class Heap(private val head: Int) {
    private val heap = mutableListOf<Int?>(null, head)

    fun printHeap() {
        println(heap)
    }

    fun insert(value: Int) {
        heap.add(value)

        val insertedIndex = heap.size - 1
        moveUp(insertedIndex / 2, insertedIndex)
    }

    fun delete() {

        val rootValue = heap[1]

        heap[1] = heap.last()


    }

    private fun moveDown(targetIndex: Int) {
        val leftIndex = targetIndex * 2
        val rightIndex = targetIndex * 2 + 1

        if (heap[leftIndex] == null && heap[rightIndex] == null) {
            return
        }


    }

    private fun moveUp(parentIndex: Int, insertedIndex: Int) {
        if (insertedIndex <= 1) {
            return
        }

        if (heap[parentIndex]!! > heap[insertedIndex]!!) {
            return
        }

        with(heap[parentIndex]) {
            heap[parentIndex] = heap[insertedIndex]
            heap[insertedIndex] = this
        }
        return moveUp(insertedIndex / 2, parentIndex)
    }
}