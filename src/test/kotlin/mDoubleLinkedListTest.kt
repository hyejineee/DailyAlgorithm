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

        doubleLinkedList.addBeforeAt(1, "a-1")

        assertThat(
            listOf("a", "a-1", "b", "c", "d"),
            equalTo(doubleLinkedList.all())
        )

        doubleLinkedList.addBeforeAt(0, "a-0")

        assertThat(
            listOf("a-0", "a", "a-1", "b", "c", "d"),
            equalTo(doubleLinkedList.all())
        )
    }

    @Test
    fun `특정 인텍스 뒤에 데이터 추가하기`() {
        val doubleLinkedList = mDoubleLinkedList("a")

        doubleLinkedList.add("b")
        doubleLinkedList.add("c")
        doubleLinkedList.add("d")

        doubleLinkedList.addAfterAt(1, "b-1")

        assertThat(
            listOf("a", "b", "b-1", "c", "d"),
            equalTo(doubleLinkedList.all())
        )

        doubleLinkedList.addAfterAt(4, "d-1")

        assertThat(
            listOf("a", "b", "b-1", "c", "d", "d-1"),
            equalTo(doubleLinkedList.all())
        )
    }

    @Test
    fun `특정 인덱스의 데이터 삭제하기`() {
        val doubleLinkedList = mDoubleLinkedList("a")

        doubleLinkedList.add("b")
        doubleLinkedList.add("c")
        doubleLinkedList.add("d")

        doubleLinkedList.deleteAt(1)

        assertThat(
            listOf("a", "c", "d"),
            equalTo(doubleLinkedList.all())
        )

        doubleLinkedList.deleteAt(0)

        assertThat(
            listOf("c", "d"),
            equalTo(doubleLinkedList.all())
        )

        doubleLinkedList.deleteAt(1)

        assertThat(
            listOf("c"),
            equalTo(doubleLinkedList.all())
        )
    }

}