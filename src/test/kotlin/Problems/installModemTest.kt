package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class installModemTest {

    @Test
    fun `공유기 설치`() {
        assertThat(
            installModem(3, listOf(1, 2, 8, 4, 9).sorted()),
            equalTo(3)
        )
    }
}