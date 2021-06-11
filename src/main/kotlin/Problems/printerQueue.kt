package Problems

import java.util.*

fun printerQueue(
    countOfDoc: Int,
    indexOfImportantDoc: Int,
    docs: IntArray
): Int {
    val printer: Queue<Pair<Int, Int>> = LinkedList()

    docs.forEachIndexed { index, i ->
        printer.add(Pair(i, index))
    }
    
    var count = 0

    while (printer.isNotEmpty()) {
        val currentDoc = printer.poll()

        if (currentDoc.first >= highPriority(printer.toList())) {
            count++

            if (currentDoc.second == indexOfImportantDoc) {
                return count
            }
            continue
        }

        printer.add(currentDoc)
    }
    return -1
}

fun highPriority(docs: List<Pair<Int, Int>>) = docs.maxOf { it.first }