package Programmers.y2022._1103


import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class 파일명_정렬KtTest {
    @Test
    fun `파일명 정렬`() {
        assertThat(
            Programmers.y2022._1103.`파일명 정렬`(
                arrayOf(
                    "img12.png",
                    "img10.png",
                    "img02.png",
                    "img1.png",
                    "IMG01.GIF",
                    "img2.JPG"
                )
            )
        ).isEqualTo(
            arrayOf(
                "img1.png",
                "IMG01.GIF",
                "img02.png",
                "img2.JPG",
                "img10.png",
                "img12.png"
            )
        )
    }
}