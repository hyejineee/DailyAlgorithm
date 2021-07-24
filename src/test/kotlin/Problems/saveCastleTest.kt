package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class saveCastleTest() {

    @Test
    fun `성 지키기`() {
        assertThat(
            saveCastle(
                3,
                4,
                arrayOf(
                    charArrayOf('.', '.', 'x', '.'),
                    charArrayOf('.', '.', 'x', '.'),
                    charArrayOf('.', '.', 'x', '.'),
                )
            ),
            equalTo(3)
        )

        assertThat(
            saveCastle(
                4,
                4,
                arrayOf(
                    charArrayOf('.', '.', '.', '.'),
                    charArrayOf('.', 'x', '.', '.'),
                    charArrayOf('.', '.', 'x', 'x'),
                    charArrayOf('.', '.', '.', '.'),
                )
            ),
            equalTo(2)
        )

        assertThat(
            saveCastle(
                4,
                4,
                arrayOf(
                    charArrayOf('x', '.', '.', '.'),
                    charArrayOf('.', 'x', '.', '.'),
                    charArrayOf('.', '.', 'x', 'x'),
                    charArrayOf('.', '.', '.', 'x'),
                )
            ),
            equalTo(0)
        )
    }
}