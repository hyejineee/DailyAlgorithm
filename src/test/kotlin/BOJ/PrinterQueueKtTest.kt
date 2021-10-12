package BOJ

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class PrinterQueueKtTest {
    @Test
    fun `프린터큐`() {
        assertThat(
            printerQueue(4, 2, intArrayOf(1, 2, 3, 4)),
            equalTo(2)
        )

        assertThat(
            printerQueue(6, 0, intArrayOf(1, 1, 9, 1, 1, 1)),
            equalTo(5)
        )

    }
}