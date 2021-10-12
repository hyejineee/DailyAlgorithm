package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class sha256Test {
    @Test
    fun `shq-256을 사용하여 해시값 출력하기`() {
        assertThat(
            "9944e1862efbb2a4e2486392dc6701896416b251eccdecb8332deb7f4cf2a857",
            equalTo(
                sha256("Baekjoon")
            )
        )
    }
}