package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test
import java.lang.StringBuilder

internal class MenuRenewalKtTest{
    @Test
    fun `menu renewal test`(){

//        assertThat(
//            menuRenewal(
//                orders = arrayOf("ABCDFG", "ABCDFEHI", "EHI", "HIJK"),
//                course = intArrayOf(2,3,4)
//            )
//        ).isEqualTo(
//            arrayOf("AC", "ACDE", "BCFG", "CDE")
//        )


        assertThat(
            menuRenewal(
                orders = arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"),
                course = intArrayOf(2,3,4)
            )
        ).isEqualTo(
            arrayOf("AC", "ACDE", "BCFG", "CDE")
        )

        assertThat(
            menuRenewal(
                orders = arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"),
                course = intArrayOf(2,3,5)
            )
        ).isEqualTo(
            arrayOf("ACD", "AD", "ADE", "CD", "XYZ")
        )

        assertThat(
            menuRenewal(
                orders = arrayOf("XYZ", "XWY", "WXA"),
                course = intArrayOf(2,3,4)
            )
        ).isEqualTo(
            arrayOf("WX", "XY")
        )
    }

//    @Test
//    fun `combination`(){
//        assertThat(
//            Programmers.combination(
//                arr = "ABCD".toCharArray(),
//                level = 2,
//                comb = "",
//                result = mutableSetOf()
//            )
//        ).isEqualTo(Unit)
//    }
}

