package BOJ

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class BlackJackKtTest {
    @Test
    fun `블랙잭`() {
        assertThat(
            blackJack(
                intArrayOf(5, 6, 7, 8, 9),
                21
            ),
            equalTo(21)
        )

        assertThat(
            blackJack(
                intArrayOf(
                    93, 181, 245, 214, 315, 36, 185, 138, 216, 295
                ),
                500
            ),
            equalTo(497)
        )
    }
}