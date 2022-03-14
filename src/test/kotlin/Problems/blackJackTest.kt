package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class blackJackTest {
    @Test
    fun `블랙잭`() {

        assertThat(
            21,
            equalTo(blackJack(intArrayOf(5, 6, 7, 8, 9), 21))
        )

        assertThat(
            497,
            equalTo(
                blackJack(
                    intArrayOf(93, 181, 245, 214, 315, 36, 185, 138, 216, 295),
                    500
                )
            )
        )


    }
}