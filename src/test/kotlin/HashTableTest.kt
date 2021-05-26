import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class HashTableTest {

    @Test
    fun `데이터 삽입`() {
        val hashTable = mHashTable()

        val keys = listOf("a", "b", "c")
        val values = listOf("01012345678", "01023456789", "01034567890")

        for (i in 0..2) {
            hashTable.put(keys[i], values[i])
        }

        assertThat(
            "01012345678",
            equalTo(
                hashTable.get("a")
            )
        )
    }
}