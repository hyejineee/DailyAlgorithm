package Problems

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class keyLoggerTest {
    @Test
    fun `키로거`() {
        assertThat(
            "BAPC",
            CoreMatchers.equalTo(
                keyLogger("<<BP<A>>Cd-")
            )
        )

        assertThat(
            "ThIsIsS3Cr3t",
            CoreMatchers.equalTo(
                keyLogger("ThIsIsS3Cr3t")
            )
        )

        assertThat(
            "ADFC",
            CoreMatchers.equalTo(
                keyLogger("ABC<<D>E<<F>>--")
            )
        )
    }
}