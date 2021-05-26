import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class HashTableTest {

    @Test
    fun `데이터 삽입, 조회`() {
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

    @Test
    fun `충돌 상황 만들기`() {

        val hashTable = mHashTable()

        val keys = listOf("a", "b", "c")
        val values = listOf("01012345678", "01023456789", "01034567890")

        for (i in 0..2) {
            hashTable.put(keys[i], values[i])
        }

        //충돌 상황 만들기 
        hashTable.put("an", "02012345678")

        /**
         *   a와 an이 충돌함.
         *      a 's key 97
        b 's key 98
        c 's key 99
        an 's key 3117
        ab 's key 3105
         * */

        assertThat(
            "a와 an의 키가 충돌하여 a가 아닌 an의 데이터가 나오게 된다.",
            "02012345678",
            equalTo(
                hashTable.get("a")
            )
        )
    }


}