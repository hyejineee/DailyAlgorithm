import junit.framework.Assert.assertEquals
import org.junit.Test

internal class LinkedListTest {
    @Test
    fun `리스트 뒤에 추가하기`() {
        val linkedList = mLinkedList("first")

        linkedList.add("2")
        linkedList.add("3")
        linkedList.add("4")
        
        assertEquals("name", linkedList.get(2))

        linkedList.printAll()
    }
}