package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StringCompressionKtTest {
    @Test
    fun `문자열 압축`() {
        assertThat(
            stringCompression("aabbaccc"),
            equalTo(7)
        )

        assertThat(
            stringCompression("abcabcdede"),
            equalTo(8)
        )

        assertThat(
            stringCompression("abcabcabcabcdededededede"),
            equalTo(14)
        )

        assertThat(
            stringCompression("xababcdcdababcdcd"),
            equalTo(17)
        )

        assertThat(
            stringCompression("a"),
            equalTo(1)
        )

    }
}