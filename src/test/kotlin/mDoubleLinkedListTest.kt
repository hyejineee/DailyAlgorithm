import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class mDoubleLinkedListTest {

    @Test
    fun `데이터 추가하기`() {
        val doubleLinkedList = mDoubleLinkedList("a")

        doubleLinkedList.add("b")
        doubleLinkedList.add("c")
        doubleLinkedList.add("d")

        assertThat(
            listOf("a", "b", "c", "d"),
            equalTo(doubleLinkedList.all())
        )
    }

    @Test
    fun `특정 인덱스 앞에 데이터 추가하기`() {
        val doubleLinkedList = mDoubleLinkedList("a")

        doubleLinkedList.add("b")
        doubleLinkedList.add("c")
        doubleLinkedList.add("d")

        doubleLinkedList.addBeforeIndex(1, "a-1")

        assertThat(
            listOf("a", "a-1", "b", "c", "d"),
            equalTo(doubleLinkedList.all())
        )
    }

}