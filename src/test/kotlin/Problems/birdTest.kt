package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class birdTest {
    @Test
    fun `새`() {
        assertThat(
            bird(14),
            equalTo(7)
        )

//        assertThat(
//            bird(10.0.pow(9).toInt()),
//            equalTo()
//        )
    }
}