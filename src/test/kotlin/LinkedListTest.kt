import junit.framework.Assert.assertEquals
import org.junit.Test

internal class LinkedListTest {
    @Test
    fun `리스트 뒤에 추가하기`() {
        val linkedList = mLinkedList()

        linkedList.add("data")
        linkedList.add("name")

        assertEquals("name", linkedList.get(2))
    }
}