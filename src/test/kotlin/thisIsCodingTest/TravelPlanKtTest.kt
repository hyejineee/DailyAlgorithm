package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class TravelPlanKtTest {
    @Test
    fun travelPlanTest(){
        assertThat(travelPlan(
            arrayOf(
                intArrayOf(0,1,0,1,1),
                intArrayOf(1,0,1,1,0),
                intArrayOf(0,1,0,0,0),
                intArrayOf(1,1,0,0,0),
                intArrayOf(1,0,0,0,0),
            ),
            intArrayOf(2,3,4,3),
            5
        )).isEqualTo("YES")
    }
}