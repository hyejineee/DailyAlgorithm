package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class make0Test {
    @Test
    fun `0만들기`() {
        assertThat(
            make0(3),
            equalTo(
                listOf(
                    "1+2-3"
                )
            )
        )

//        assertThat(
//            make0(9),
//            equalTo(
//                listOf(
//                    "1+2-3"
//                )
//            )
//        )


        assertThat(
            make0(7),
            equalTo(
                listOf(
                    "1+2-3+4-5-6+7",
                    "1+2-3-4+5+6-7",
                    "1-2 3+4+5+6+7",
                    "1-2 3-4 5+6 7",
                    "1-2+3+4-5+6-7",
                    "1-2-3-4-5+6+7"
                )
            )
        )
    }
}