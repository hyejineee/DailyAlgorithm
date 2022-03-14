package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class numberSort3Test {
    @Test
    fun `수 정렬하기`() {

        assertThat(
            arrayOf(1, 1, 2, 2, 3, 3, 4, 5, 5, 7),
            equalTo(
                numberSort3(
                    arrayOf(5, 2, 3, 1, 4, 2, 3, 5, 1, 7)
                )
            )
        )

        var numbers = mutableListOf<Int>()
        for (i in 1..100) {
            numbers.addAll((1..10000).shuffled().toTypedArray())
        }


        assertThat(
            numbers.sorted().toTypedArray(),
            equalTo(
                numberSort3(
                    numbers.toTypedArray()
                )
            )
        )
    }
}