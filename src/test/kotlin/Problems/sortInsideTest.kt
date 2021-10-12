package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class sortInsideTest {
    @Test
    fun `내림차순으로 정렬하기`() {
        assertThat(
            4321,
            equalTo(
                sortInside(2143)
            )
        )

        assertThat(
            998872,
            equalTo(
                sortInside(988297)
            )
        )
    }
}