package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class ExactRankingKtTest {
    @Test
    fun exactRankingTest() {
        assertThat(
            exactRanking(
                6,
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(3, 4),
                    intArrayOf(4, 2),
                    intArrayOf(4, 6),
                    intArrayOf(5, 2),
                    intArrayOf(5, 4),
                )
            )
        ).isEqualTo(1)
    }
}