import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class mDoubleLinkedListTest {

    @Test
    fun `데이터 추가하기`() {
        val doubleLinkedList = mDoubleLinkedList()

        doubleLinkedList.add("a")
        doubleLinkedList.add("b")
        doubleLinkedList.add("c")
        doubleLinkedList.add("d")
        
        assertThat(arrayOf("a", "b", "c", "d"), doubleLinkedList.all())
    }

}