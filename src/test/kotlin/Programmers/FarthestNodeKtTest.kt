package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

internal class FarthestNodeKtTest {
    @Test
    fun `가장 먼 노드 테스트`() {
        assertThat(
            farthestNode(
                6,
                arrayOf(
                    intArrayOf(3, 6),
                    intArrayOf(4, 3),
                    intArrayOf(3, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 2),
                    intArrayOf(2, 4),
                    intArrayOf(5, 2)
                )
            )
        ).isEqualTo(3)
    }
}