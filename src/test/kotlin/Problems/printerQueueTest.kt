package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class printerQueueTest {
    @Test
    fun `프린터 큐`() {
        assertThat(
            2,
            equalTo(
                printerQueue(
                    4,
                    2,
                    intArrayOf(1, 2, 3, 4)
                )
            )
        )
    }


    @Test
    fun `제일 높은 우선 순위 문서 찾기 `() {

        assertThat(
            4,
            equalTo(highPriority(listOf(Pair(1, 0), Pair(2, 1), Pair(4, 2), Pair(3, 3))))
        )

    }

}