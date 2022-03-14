package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

internal class RotateMatrixKtTest() {

    @Test
    fun `rotate test`() {
        assertThat(
            rotateMatrixToLeft(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9),
                    intArrayOf(10, 11, 12),
                ),
                4,
                3
            )
        )
            .isEqualTo(
                arrayOf(
                    intArrayOf(3, 6, 9, 12),
                    intArrayOf(2, 5, 8, 11),
                    intArrayOf(1, 4, 7, 10),
                )
            )

        assertThat(
            rotateMatrixToLeft(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9),
                ),
                3,
                3
            )
        )
            .isEqualTo(
                arrayOf(
                    intArrayOf(3, 6, 9),
                    intArrayOf(2, 5, 8),
                    intArrayOf(1, 4, 7),
                )
            )

        assertThat(
            rotateMatrixToLeft(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12),

                    ),
                3,
                4
            )
        )
            .isEqualTo(
                arrayOf(
                    intArrayOf(4, 8, 12),
                    intArrayOf(3, 7, 11),
                    intArrayOf(2, 6, 10),
                    intArrayOf(1, 5, 9),
                )
            )
    }

    @Test
    fun `rotate to right test`() {
        assertThat(
            rotateMatrixToRight(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9),
                    intArrayOf(10, 11, 12),
                ),
                4,
                3
            )
        )
            .isEqualTo(
                arrayOf(
                    intArrayOf(10,7,4,1),
                    intArrayOf(11,8,5,2),
                    intArrayOf(12,9,6,3),
                )
            )

    }

}