package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RepeatBinaryConvertKtTest {

    @Test
    fun `이진 변환 반복하기  `() {
        assertThat(
            repeatBinaryConvert("01110"),
            equalTo(
                intArrayOf(3, 3)
            )
        )

        listOf(0).sorted()
    }


}