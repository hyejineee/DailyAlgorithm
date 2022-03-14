package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class kthNumberTest {
    @Test
    fun `k번째 수`() {
        assertThat(
            kthNumber(3, 7),
            equalTo(
                6
            )
        )
    }
}