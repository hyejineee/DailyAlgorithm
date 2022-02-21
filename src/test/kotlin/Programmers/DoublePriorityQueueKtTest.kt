package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class DoublePriorityQueueKtTest {
    @Test
    fun doublePriorityQueueTest() {
        assertThat(doublePriorityQueue(arrayOf("I 7", "I 5", "I -5", "D -1"))).isEqualTo(intArrayOf(7, 5))
        assertThat(doublePriorityQueue(arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"))).isEqualTo(
            intArrayOf(0, 0)
        )
        assertThat(
            doublePriorityQueue(
                arrayOf(
                    "I -45",
                    "I 653",
                    "D 1",
                    "I -642",
                    "I 45",
                    "I 97",
                    "D 1",
                    "D -1",
                    "I 333"
                )
            )
        ).isEqualTo(intArrayOf(333, -45))
    }
}