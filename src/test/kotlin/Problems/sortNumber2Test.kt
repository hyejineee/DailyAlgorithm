package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class sortNumber2Test {
    @Test
    fun `수 정렬하기 2`() {
//        assertThat(
//            sortNumber2(intArrayOf(5, 4, 3, 2, 1)),
//            equalTo(
//                arrayOf(1, 2, 3, 4, 5)
//            )
//        )

        val array = (0..1000000).shuffled().toIntArray()
        assertThat(
            sortNumber2(array),
            equalTo(
                (0..1000000).toList().toIntArray().joinToString("") {
                    it.toString() + "\n"
                }
            )
        )

    }
}