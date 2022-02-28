package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class GetReportedResultKtTest {
    @Test
    fun getReportedResultTest() {
        assertThat(
            getReportedResult(
                arrayOf("muzi", "frodo", "apeach", "neo"),
                arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
                2
            )
        ).isEqualTo(
            intArrayOf(2, 1, 1, 0)
        )

        assertThat(
            getReportedResult(
                arrayOf("con", "ryan"),
                arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
                3
            )
        ).isEqualTo(
            intArrayOf(0,0)
        )
    }
}