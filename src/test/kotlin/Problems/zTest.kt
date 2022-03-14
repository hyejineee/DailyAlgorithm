package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class zTest {
    @Test
    fun `z모양으로 방문하기`() {
//        assertThat(
//            z(2, 3, 1),
//            equalTo(
//                11
//            )
//        )
//
//        assertThat(
//            z(2, 0, 0),
//            equalTo(
//                0
//            )
//        )
//
//
//        assertThat(
//            z(2, 2, 2),
//            equalTo(
//                12
//            )
//        )
//        assertThat(
//            z(3, 7, 7),
//            equalTo(
//                63
//            )
//        )
//
//        assertThat(
//            z(3, 5, 5),
//            equalTo(
//                51
//            )
//        )
//
//        assertThat(
//            z(4, 15, 15),
//            equalTo(
//                255
//            )
//        )
//
//        assertThat(
//            z(15, 32767, 32767),
//            equalTo(
//                1073741823
//            )
//        )

//        assertThat(
//            z(15, 1, 1),
//            equalTo(
//                3
//            )
//        )

        assertThat(
            z(15, 2, 2),
            equalTo(
                12
            )
        )

        assertThat(
            z(15, 2, 1),
            equalTo(
                9
            )
        )
//
//        assertThat(
//            z(1, 0, 0),
//            equalTo(
//                0
//            )
//        )
    }


}