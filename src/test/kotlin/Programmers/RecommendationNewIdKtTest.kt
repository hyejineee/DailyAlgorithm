package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RecommendationNewIdKtTest {
    @Test

    fun `신규 아이디 추천`() {

        assertThat(
            recommendationNewId("...!@BaT#*..y.abcdefghijklm"),
            equalTo("bat.y.abcdefghi")
        )

        assertThat(
            recommendationNewId("z-+.^."),
            equalTo("z--")
        )

        assertThat(
            recommendationNewId("=.="),
            equalTo("aaa")
        )

        assertThat(
            recommendationNewId("123_.def"),
            equalTo("123_.def")
        )
//
        assertThat(
            recommendationNewId("abcdefghijklmn.p"),
            equalTo("abcdefghijklmn")
        )
    }

    
    @Test
    fun `3단계 테스트_연속한 점 하나로 바꾸기 `() {
        assertThat(
            step3("...hi.123....i"),
            equalTo(".hi.123.i")
        )
    }

    @Test
    fun `4단계 테스트_맨 앞 맨뒤 점 제거하기`() {
        assertThat(
            step4("..hi.123.i.."),
            equalTo("hi.123.i")
        )
    }

    @Test
    fun `6단계 테스트_15자 이상 제거하기 `() {
        assertThat(
            step6("12345678912345.666"),
            equalTo("12345678912345")
        )

        assertThat(
            step6("abcdefghijklmn.p"),
            equalTo("abcdefghijklmn")
        )
    }

    @Test
    fun `7단계 테스트_2자 이하일 경우 `() {
        assertThat(
            step7("a"),
            equalTo("aaa")
        )
    }

}