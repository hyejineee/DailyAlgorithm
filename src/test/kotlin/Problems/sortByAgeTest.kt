package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class sortByAgeTest {

    @Test
    fun `나이순 정렬`() {

        assertThat(
            arrayOf(arrayOf("20", "Sunyoung"), arrayOf("21", "Junkyu"), arrayOf("21", "Dohyun")),
            equalTo(
                sortByAge(
                    arrayOf(
                        arrayOf("21", "Junkyu"),
                        arrayOf("21", "Dohyun"),
                        arrayOf("20", "Sunyoung")
                    )
                )
            )
        )
    }
}