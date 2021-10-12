import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

internal class mBinarySerarchTreeTest {
    val data = arrayOf(21, 14, 11, 10, 18, 22, 23, 27, 30)

    @Test
    fun `데이터 넣기`() {

        val binarySearchTree = mBinarySerarchTree()

        data.forEach {
            binarySearchTree.add(it)
        }

        data.forEach {
            assertThat(
                true,
                equalTo(binarySearchTree.find(it))
            )
        }
    }
    

    @Test
    fun `데이터 삭제`() {

        val binarySearchTree = mBinarySerarchTree()

        data.forEach {
            binarySearchTree.add(it)
        }

        assertThat(
            true,
            equalTo(binarySearchTree.find(14))
        )

//        binarySearchTree.delete(14)
//
//        assertThat(
//            false,
//            equalTo(binarySearchTree.find(14))
//        )
//
//        assertThat(
//            true,
//            equalTo(binarySearchTree.find(11))
//        )
//
//        assertThat(
//            true,
//            equalTo(binarySearchTree.find(10))
//        )

        binarySearchTree.delete(22)

        assertThat(
            true,
            equalTo(binarySearchTree.find(23))
        )

        assertThat(
            true,
            equalTo(binarySearchTree.find(27))
        )

        assertThat(
            false,
            equalTo(binarySearchTree.find(22))
        )
    }
}