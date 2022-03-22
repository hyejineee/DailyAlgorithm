package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class CandidateKeyKtTest {
    @Test
    fun candidateKeyTest() {
//        assertThat(
//            candidateKey(
//                arrayOf(
//                    arrayOf("100", "ryan", "music", "2"),
//                    arrayOf("200", "apeach", "math", "2"),
//                    arrayOf("300", "tube", "computer", "3"),
//                    arrayOf("400", "con", "computer", "4"),
//                    arrayOf("500", "muzi", "music", "3"),
//                    arrayOf("600", "apeach", "music", "2")
//                )
//            )
//        ).isEqualTo(2)

        assertThat(
            candidateKey(
                arrayOf(
                    arrayOf("a","1","aaa","c","ng"),
                    arrayOf("b","1","bbb","c","g"),
                    arrayOf("c","1","aaa","d","ng"),
                    arrayOf("d","2","bbb","d","ng"),
                )
            )
        ).isEqualTo(3)
    }
}