package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class GraphTest {
    val method = Graph()

    @Test
    fun teamFormationTest() {
        assertThat(
            method.teamFormation(
                7,
                arrayOf(
                    intArrayOf(0, 1, 3),
                    intArrayOf(1, 1, 7),
                    intArrayOf(0, 7, 6),
                    intArrayOf(1, 7, 1),
                    intArrayOf(0, 3, 7),
                    intArrayOf(0, 4, 2),
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 1, 1),
                )
            )
        ).isEqualTo(arrayOf("NO", "NO", "YES"))
    }

    @Test
    fun cityDivisionPlanTest() {
        assertThat(
            method.cityDivisionPlan(
                7,
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(1, 2, 2),
                    intArrayOf(3, 2, 1),
                    intArrayOf(2, 5, 2),
                    intArrayOf(3, 4, 4),
                    intArrayOf(7, 3, 6),
                    intArrayOf(5, 1, 5),
                    intArrayOf(1, 6, 2),
                    intArrayOf(6, 4, 1),
                    intArrayOf(6, 5, 3),
                    intArrayOf(4, 5, 3),
                    intArrayOf(6, 7, 4),
                )
            )
        ).isEqualTo(8)
    }

    @Test
    fun curriculumTest() {
        assertThat(
            method.curriculum(
                arrayOf(
                    intArrayOf(10),
                    intArrayOf(10, 1),
                    intArrayOf(4, 1),
                    intArrayOf(4, 3, 1),
                    intArrayOf(3, 3),
                )
            )
        ).isEqualTo(intArrayOf(10,20,14,18,17))
    }

}