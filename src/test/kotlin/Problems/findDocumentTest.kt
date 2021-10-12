package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class findDocumentTest {
    @Test
    fun `문서 찾기`() {

        assertThat(
            findDocument("ababababa", "aba"),
            equalTo(2)
        )

        assertThat(
            findDocument("a a a a a", "a a"),
            equalTo(2)
        )

        assertThat(
            findDocument("abababa", "ababa"),
            equalTo(1)
        )
        assertThat(
            findDocument("aba", "a"),
            equalTo(2)
        )

    }

    @Test
    fun `단어와 문서의 앞 단어가 맞는지 확인하기`() {
        assertThat(
            matches("ababababa".toCharArray(), "aba".toCharArray()),
            equalTo(true)
        )
    }
}