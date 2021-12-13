package Programmers


import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

internal class RotateMatrixBordersKtTest {
    @Test
    fun `행렬 테두리 회전하기`() {
        assertThat(
            rotateMatrixBorders(
                6, 6, arrayOf(
                    intArrayOf(2, 2, 5, 4),
                    intArrayOf(3, 3, 6, 6),
                    intArrayOf(5, 1, 6, 3),
                )
            )
        ).isEqualTo(
            intArrayOf(8, 10, 25)
        )

        assertThat(
            rotateMatrixBorders(
                3, 3, arrayOf(
                    intArrayOf(1,1,2,2,),
                    intArrayOf(1,2,2,3),
                    intArrayOf(2,1,3,2),
                    intArrayOf(2,2,3,3),
                )
            )
        ).isEqualTo(
            intArrayOf(1,1,5,3)
        )

        assertThat(
            rotateMatrixBorders(
                100, 97, arrayOf(
                    intArrayOf(1,1,100,97),
                )
            )
        ).isEqualTo(
            intArrayOf(1)
        )
    }

    @Test
    fun `회전할 부분 행렬 가져오기`() {
        assertThat(
            getSubMatrix(
                2, 2, 5, 4,
                origin = arrayOf(
                    intArrayOf(1, 2, 3, 4, 5, 6),
                    intArrayOf(7, 8, 9, 10, 11, 12),
                    intArrayOf(13, 14, 15, 16, 17, 18),
                    intArrayOf(19, 20, 21, 22, 23, 24),
                    intArrayOf(25, 26, 27, 28, 29, 30),
                    intArrayOf(31, 32, 33, 34, 35, 36),
                    )
            )
        ).isEqualTo(
            arrayOf(
                intArrayOf(8,9,10),
                intArrayOf(14,15,16),
                intArrayOf(20,21,22),
                intArrayOf(26,27,28),
            )
        )
    }

    @Test
    fun `테두리 회전하기`(){
        assertThat(rotateBorder(
            arrayOf(
                intArrayOf(8,9,10),
                intArrayOf(14,15,16),
                intArrayOf(20,21,22),
                intArrayOf(26,27,28),
            ),
            4,3
        )).isEqualTo(
            arrayOf(
                intArrayOf(14,8,9),
                intArrayOf(20,15,10),
                intArrayOf(26,21,16),
                intArrayOf(27,28,22),
            )
        )

        assertThat(rotateBorder(
            arrayOf(
                intArrayOf(1,2),
                intArrayOf(4,5),
            ),
            2,2
        )).isEqualTo(
            arrayOf(
                intArrayOf(4,1),
                intArrayOf(5,2),
            )
        )
    }
}