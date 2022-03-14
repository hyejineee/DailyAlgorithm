package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class CompressStringKtTest {
    @Test
    fun compressStringTest(){
//        assertThat(compressString("abcabcabcabcdededededede")).isEqualTo(14)
//        assertThat(compressString("ababcdcdababcdcd")).isEqualTo(9)
//        assertThat(compressString("xababcdcdababcdcd")).isEqualTo(17)
//        assertThat(compressString("aabbaccc")).isEqualTo(7)
//        assertThat(compressString("abcabcdede")).isEqualTo(8)
//        assertThat(compressString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")).isEqualTo(4)
//        assertThat(compressString("acacacacacacbacacacacacac")).isEqualTo(9)
//        assertThat(compressString("acacacbacacac")).isEqualTo(9)
        assertThat(compressString("a")).isEqualTo(1)
        assertThat(compressString("aa")).isEqualTo(2)
        assertThat(compressString("aaa")).isEqualTo(2)
    }
}