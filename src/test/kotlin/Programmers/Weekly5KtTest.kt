package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class Weekly5KtTest {
    @Test
    fun `위클리 챌린지 5주차`() {
        assertThat(
            weekly5("AAAAE"),
            equalTo(6)
        )

        assertThat(
            weekly5("AAAE"),
            equalTo(10)
        )

        assertThat(
            weekly5("I"),
            equalTo(1563)
        )

        assertThat(
            weekly5("EIO"),
            equalTo(1189)
        )
    }
}