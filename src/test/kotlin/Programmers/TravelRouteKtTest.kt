package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class TravelRouteKtTest {
    @Test
    fun `여행 경로 테스트`() {
//        assertThat(
//            travelRoute(
//                arrayOf(
//                    arrayOf("ICN", "JFK"),
//                    arrayOf("HND", "IAD"),
//                    arrayOf("JFK", "HND")
//                )
//            )
//        ).isEqualTo(
//            arrayOf("ICN", "JFK", "HND", "IAD")
//        )
//
//        assertThat(
//            travelRoute(
//                arrayOf(
//                    arrayOf("ICN", "SFO"),
//                    arrayOf("ICN", "ATL"),
//                    arrayOf("SFO", "ATL"),
//                    arrayOf("ATL", "ICN"),
//                    arrayOf("ATL", "SFO")
//                )
//            )
//        ).isEqualTo(
//            arrayOf("ICN", "ATL", "ICN", "SFO", "ATL", "SFO")
//        )
//
//        assertThat(
//            travelRoute(
//                arrayOf(
//                    arrayOf("ICN", "A"),
//                    arrayOf("A", "B"),
//                    arrayOf("A", "C"),
//                    arrayOf("C", "A"),
//                    arrayOf("B", "D")
//                )
//            )
//        ).isEqualTo(
//            arrayOf("ICN", "A", "C", "A", "B", "D")
//        )

        assertThat(
            travelRoute(
                arrayOf(
                    arrayOf("ICN", "BOO"),
                    arrayOf("ICN", "COO"),
                    arrayOf("COO", "DOO"),
                    arrayOf("DOO", "COO"),
                    arrayOf("BOO", "DOO"),
                    arrayOf("DOO", "BOO"),
                    arrayOf("BOO", "ICN"),
                    arrayOf("COO", "BOO")
                )
            )
        ).isEqualTo(
            arrayOf("ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO")
        )
    }


}