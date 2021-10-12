package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MakeStringOfJadenCaseKtTest {
    @Test
    fun `jaden case 문자열 만들기`() {
        assertThat(
            makeStringOfJadenCase("3people unFollowed me"),
            equalTo(
                "3people Unfollowed Me"
            )
        )

        assertThat(
            makeStringOfJadenCase("for the last week"),
            equalTo(
                "For The Last Week"
            )
        )

        assertThat(
            makeStringOfJadenCase("a     "),
            equalTo(
                "A     "
            )
        )

        assertThat(
            makeStringOfJadenCase("aa    3 b  cc"),
            equalTo(
                "Aa    3 B  Cc"
            )
        )

        assertThat(
            makeStringOfJadenCase("Aa    3 b  cc"),
            equalTo(
                "Aa    3 B  Cc"
            )
        )

        assertThat(
            makeStringOfJadenCase(" adgagd 3eagdag "),
            equalTo(
                " Adgagd 3eagdag "
            )
        )

        assertThat(
            makeStringOfJadenCase(" "),
            equalTo(
                " "
            )
        )

        assertThat(
            makeStringOfJadenCase("aaaaaa AaaaA aaaa"),
            equalTo(
                "aaaaaa Aaaaa aaaa"
            )
        )
    }
}