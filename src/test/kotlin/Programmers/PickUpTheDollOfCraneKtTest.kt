package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class PickUpTheDollOfCraneKtTest {

    @Test
    fun `크레인 인형 뽑기`() {
        assertThat(
            pickUpTheDollOfCrane(
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 1, 0, 3),
                    intArrayOf(0, 2, 5, 0, 1),
                    intArrayOf(4, 2, 4, 4, 2),
                    intArrayOf(3, 5, 1, 3, 1),
                ),
                intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
            ),
            equalTo(4)
        )


//        assertThat(
//            pickUpTheDollOfCrane(
//                arrayOf(
//                    intArrayOf(0, 0, 1, 0, 0),
//                    intArrayOf(0, 0, 1, 0, 0),
//                    intArrayOf(0, 2, 1, 0, 0),
//                    intArrayOf(0, 2, 1, 0, 0),
//                    intArrayOf(0, 2, 1, 0, 0),
//                ),
//                intArrayOf(1, 2, 3, 3, 2, 3, 1)
//            ),
//            equalTo(4)
//        )
    }
}