package BOJ

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class Sha256KtTest {
    @Test
    fun `sha-256`() {
        assertThat(
            sha256("Baekjoon"),
            equalTo(
                "9944e1862efbb2a4e2486392dc6701896416b251eccdecb8332deb7f4cf2a857"
            )
        )
    }
}