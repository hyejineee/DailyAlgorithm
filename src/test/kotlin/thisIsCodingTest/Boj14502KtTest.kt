package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class Boj14502KtTest {
    @Test
    fun laboratoryTest() {
        assertThat(
            laboratory(
                7, 7,
                arrayOf(
                    intArrayOf(2, 0, 0, 0, 1, 1, 0),
                    intArrayOf(0, 0, 1, 0, 1, 2, 0),
                    intArrayOf(0, 1, 1, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 1, 1),
                    intArrayOf(0, 1, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 0, 0, 0, 0, 0)
                )
            )
        ).isEqualTo(27)

        assertThat(
            laboratory(
                8, 8,
                arrayOf(
                    intArrayOf(2, 0, 0, 0, 0, 0, 0, 2),
                    intArrayOf(2, 0, 0, 0, 0, 0, 0, 2),
                    intArrayOf(2, 0, 0, 0, 0, 0, 0, 2),
                    intArrayOf(2, 0, 0, 0, 0, 0, 0, 2),
                    intArrayOf(2, 0, 0, 0, 0, 0, 0, 2),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
                )
            )
        ).isEqualTo(3)

//        assertThat(
//            laboratory(
//                3, 4,
//                arrayOf(
//                    intArrayOf(2, 0, 0, 0),
//                    intArrayOf(0, 0, 1, 0),
//                    intArrayOf(0, 1, 1, 0),
//                )
//            )
//        ).isEqualTo(27)
    }
}