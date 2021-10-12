package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MatrixMultiplicationKtTest {
    @Test
    fun `행렬의 곱셈`() {
        assertThat(
            matrixMultiplication(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(3, 2),
                    intArrayOf(4, 1),
                ),
                arrayOf(
                    intArrayOf(3, 3),
                    intArrayOf(3, 3)
                )
            ),
            equalTo(
                arrayOf(
                    intArrayOf(15, 15),
                    intArrayOf(15, 15),
                    intArrayOf(15, 15),
                )
            )
        )

        assertThat(
            matrixMultiplication(
                arrayOf(
                    intArrayOf(2, 3, 2),
                    intArrayOf(4, 2, 4),
                    intArrayOf(3, 1, 4),
                ),
                arrayOf(
                    intArrayOf(5, 4, 3),
                    intArrayOf(2, 4, 1),
                    intArrayOf(3, 1, 1)
                )
            ),
            equalTo(
                arrayOf(
                    intArrayOf(22, 22, 11),
                    intArrayOf(36, 28, 18),
                    intArrayOf(29, 20, 14),
                )
            )
        )


        assertThat(
            matrixMultiplication(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(2, 3, 4),
                ),
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 1)
                )
            ),
            equalTo(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(2, 3, 4),
                )
            )
        )

        assertThat(
            matrixMultiplication(
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1),
                ),
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(2, 3, 4),
                )
            ),
            equalTo(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(2, 3, 4),
                )
            )
        )
    }


    @Test
    fun `행렬 뒤집기`() {
        assertThat(
            rotate(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(2, 3, 4)
                )
            ),
            equalTo(
                arrayOf(
                    intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4),
                )
            )
        )
    }
}