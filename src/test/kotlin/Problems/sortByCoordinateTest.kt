package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class sortByCoordinateTest {
    @Test
    fun `좌표 정렬하기`() {

        assertThat(
            arrayOf(arrayOf(1, -1), arrayOf(1, 1), arrayOf(2, 2), arrayOf(3, 3), arrayOf(3, 4)),
            equalTo(
                sortByCoordinate(
                    arrayOf(
                        arrayOf(3, 4),
                        arrayOf(1, 1),
                        arrayOf(1, -1),
                        arrayOf(2, 2),
                        arrayOf(3, 3)
                    )
                )
            )
        )
    }
}