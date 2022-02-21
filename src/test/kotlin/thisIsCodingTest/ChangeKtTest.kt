package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class ChangeKtTest{
    @Test
    fun changeTest(){
        assertThat(change(1260)).isEqualTo(6)
    }
}