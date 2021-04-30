import junit.framework.Assert.assertEquals
import org.junit.Test

internal class LinkedListTest {
    @Test
    fun `데이터 추가하기`() {
        val linkedList = mLinkedList("first")

        linkedList.add("hi")
        linkedList.add("name")
        linkedList.add("bye")

        assertEquals("bye", linkedList.get(3))
    }


}