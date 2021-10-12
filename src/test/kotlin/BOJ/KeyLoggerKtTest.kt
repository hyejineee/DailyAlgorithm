package BOJ

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class KeyLoggerKtTest {
    @Test
    fun `키로거`() {
        assertThat(
            keyLogger("<<BP<A>>Cd-"),
            equalTo("BAPC")
        )

        assertThat(
            keyLogger("ThIsIsS3Cr3t"),
            equalTo("ThIsIsS3Cr3t")
        )

        assertThat(
            keyLogger("<<<<"),
            equalTo("")
        )

        assertThat(
            keyLogger("AB<<CD"),
            equalTo("CDAB")
        )
    }
}