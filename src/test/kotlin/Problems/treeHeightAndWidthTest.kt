package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class treeHeightAndWidthTest {
    @Test
    fun `트리 높이와 너비`() {

        val tree = mapOf(
            (1 to listOf(2, 3)),
            (2 to listOf(4, 5)),
            (3 to listOf(6, 7)),
            (4 to listOf(8, -1)),
            (5 to listOf(9, 10)),
            (6 to listOf(11, 12)),
            (7 to listOf(13, -1)),
            (8 to listOf(-1, -1)),
            (9 to listOf(14, 15)),
            (10 to listOf(-1, -1)),
            (11 to listOf(16, -1)),
            (12 to listOf(-1, -1)),
            (13 to listOf(17, -1)),
            (14 to listOf(-1, -1)),
            (15 to listOf(18, -1)),
            (16 to listOf(-1, -1)),
            (17 to listOf(-1, 19)),
            (18 to listOf(-1, -1)),
            (19 to listOf(-1, -1)),
        )

        assertThat(
            treeHeightAndWidth(tree),
            equalTo(listOf(3, 18))
        )

    }
}