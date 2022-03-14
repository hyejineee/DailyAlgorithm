package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class AlphabetKtTest {
    @Test
    fun `알파벳`() {
        assertThat(
            alphabet(
                arrayOf(
                    "CAAB",
                    "ADCB"
                )
            ),
            equalTo(3)
        )

        assertThat(
            alphabet(

                arrayOf(
                    "HFDFFB",
                    "AJHGDH",
                    "DGAGEH"
                )
            ),
            equalTo(6)
        )

        assertThat(
            alphabet(
                arrayOf(
                    "IEFCJ",
                    "FHFKC",
                    "FFALF",
                    "HFGCF",
                    "HMCHH",
                )
            ),
            equalTo(10)
        )
//
//        assertThat(
//            alphabet(
//                1, 1,
//                arrayOf(
//                    "A",
//                )
//            ),
//            equalTo(1)
//        )
//
//        assertThat(
//            alphabet(
//                2, 2,
//                arrayOf(
//                    "AB",
//                    "BA",
//                )
//            ),
//            equalTo(2)
//        )
//        assertThat(
//            alphabet(
//                2, 2,
//                arrayOf(
//                    "AA",
//                    "AA",
//                )
//            ),
//            equalTo(1)
//        )

        assertThat(
            alphabet(

                arrayOf(
                    "IEFCJFHFKCFFALFHFGCF",
                    "SDDASDDDFLDSFIEOBIOV",
                    "FFAFSFEKOIVBALKSNCAL",
                    "ADFEGLOPBIAOISDFNKEM",
                    "EKLANIOEBAISDCCAKLSD",
                    "IEFCJFHFKCFFALFHFGCF",
                    "FHFKCDSKFLDSFIEOBIOV",
                    "FFALFASDFEOIEBVVVKSD",
                    "HFGCFDHAOOOOOEIFBBDM",
                    "HMCHHAHBBCIDOIWOBBAI",
                    "IEFCJFHFKCFFALFHFGCF",
                    "FHFKCDSKFLDSFIEOBIOV",
                    "FFALFASDFEOIEBVVVKSD",
                    "HFGCFDHAOOOOOEIFBBDM",
                    "HMCHHAHBBCIDOIWOBBAI",
                    "IEFCJFHFKCFFALFHFGCF",
                    "FHFKCDSKFLDSFIEOBIOV",
                    "FFALFASDFEOIEBVVVKSD",
                    "HFGCFDHAOOOOOEIFBBDM",
                    "HMCHHAHBBCIDOIWOBBAI",
                )
            ),
            equalTo(20)
        )
    }
}