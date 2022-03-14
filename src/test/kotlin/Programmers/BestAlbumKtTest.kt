package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class BestAlbumKtTest {
    @Test
    fun bestAlbumTest() {
        assertThat(
            bestAlbum(
                arrayOf("classic", "pop", "classic", "classic", "pop"),
                intArrayOf(500, 600, 150, 800, 2500)
            )
        ).isEqualTo(
            intArrayOf(4, 1, 3, 0)
        )
    }
}