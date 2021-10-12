package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class friendNetworkTest {

    @Test
    fun `친구 네트워크`() {
        assertThat(
            intArrayOf(2, 3, 4),
            equalTo(
                friendNetwork(
                    3,
                    arrayOf(
                        arrayOf("Fred", "Barney"),
                        arrayOf("Barney", "Betty"),
                        arrayOf("Betty", "Wilma"),
                    )
                )
            )
        )

        assertThat(
            intArrayOf(2, 2, 4),
            equalTo(
                friendNetwork(
                    3,
                    arrayOf(
                        arrayOf("Fred", "Barney"),
                        arrayOf("Betty", "Wilma"),
                        arrayOf("Barney", "Betty")
                    )
                )
            )
        )


    }
}