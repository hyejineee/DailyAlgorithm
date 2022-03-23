package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class IntegerTriangleKtTest {
    @Test
    fun integerTriangleTest() {
        assertThat(
            integerTriangle(
                5,
                arrayOf(
                    intArrayOf(7),
                    intArrayOf(3,8),
                    intArrayOf(8,1,0),
                    intArrayOf(2,7,4,4),
                    intArrayOf(4,5,2,6,5),
                )
            )
        ).isEqualTo(30)
    }
}