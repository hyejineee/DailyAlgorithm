package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class DeliveryKtTest {
    @Test
    fun deliveryTest() {
        assertThat(
            delivery(
                5,
                arrayOf(
                    intArrayOf(1, 2, 1),
                    intArrayOf(2, 3, 3),
                    intArrayOf(5, 2, 2),
                    intArrayOf(1, 4, 2),
                    intArrayOf(5, 3, 1),
                    intArrayOf(5, 4, 2),
                ), 3
            )
        ).isEqualTo(4)
    }
}