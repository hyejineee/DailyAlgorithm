package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RepeatBinaryConvertKtTest {
    @Test
    fun `이진수로 바꾸기 `() {
        assertThat(
            toBinary(10),
            equalTo("1010")
        )
    }

    @Test
    fun `이진 변환 반복하기  `() {
        assertThat(
            repeatBinaryConvert("01110"),
            equalTo(
                intArrayOf(3, 3)
            )
        )
    }


}