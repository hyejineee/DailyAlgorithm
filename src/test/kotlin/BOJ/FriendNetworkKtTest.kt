package BOJ

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class FriendNetworkKtTest {
    @Test
    fun `친구네트워크 `() {
//        assertThat(
//            friendNetwork(
//
//                listOf(
//                    listOf("Fred", "Barney"), listOf("Barney", "Betty"), listOf("Betty", "Wilma"),
//                )
//            ),
//            equalTo(listOf(2, 3, 4))
//        )

        assertThat(
            friendNetwork(

                listOf(
                    listOf("Fred", "Barney"), listOf("Betty", "Wilma"), listOf("Barney", "Betty"),
                )
            ),
            equalTo(listOf(2, 2, 4))
        )

    }
}