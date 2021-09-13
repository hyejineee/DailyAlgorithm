package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CalculateInsufficientAmountTest {
    @Test
    fun `부족한 금액 계산하기`() {
        assertThat(
            calculateInsufficientAmount(3, 20, 4),
            equalTo(10)
        )
    }
}