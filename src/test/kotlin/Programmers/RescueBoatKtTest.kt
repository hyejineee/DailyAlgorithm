package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class RescueBoatKtTest{

    @Test
    fun rescueBoatTest(){


        assertThat(rescueBoat(intArrayOf(50,50,70,80, 20), 100)).isEqualTo(3)
        assertThat(rescueBoat(intArrayOf(50,50,70,80), 100)).isEqualTo(3)
        assertThat(rescueBoat(intArrayOf(40, 40, 40), 100)).isEqualTo(2)

        assertThat(rescueBoat(intArrayOf(70, 50, 80, 50), 100)).isEqualTo(3)
        assertThat(rescueBoat(intArrayOf(70, 80, 50), 100)).isEqualTo(3)
        assertThat(rescueBoat(intArrayOf(40, 40, 80), 160)).isEqualTo(2)
        assertThat(rescueBoat(intArrayOf(40, 50, 60, 70, 80, 90), 100)).isEqualTo(5)
        assertThat(rescueBoat(intArrayOf(20, 50, 50, 80), 100)).isEqualTo(2)

    }
}