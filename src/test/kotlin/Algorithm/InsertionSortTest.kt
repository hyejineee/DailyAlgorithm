package Algorithm

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test


class InsertionSortTest {

    @Test
    fun `삽입 정렬`() {
        val data = intArrayOf(5, 3, 2, 4)

        MatcherAssert.assertThat(
            intArrayOf(2, 3, 4, 5),
            CoreMatchers.equalTo(insertionSort(data))
        )
    }
}