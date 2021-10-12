package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class JobRecommendationKtTest {
    @Test
    fun `직업군 추천`() {

        val table = arrayOf(
            "SI JAVA JAVASCRIPT SQL PYTHON C#",
            "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
            "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
            "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
            "GAME C++ C# JAVASCRIPT C JAVA"
        )

        assertThat(
            jobRecommendation(table, arrayOf("PYTHON", "C++", "SQL"), intArrayOf(7, 5, 5)),
            equalTo("HARDWARE")
        )

        assertThat(
            jobRecommendation(table, arrayOf("JAVA", "JAVASCRIPT"), intArrayOf(7, 5)),
            equalTo("PORTAL")
        )

    }
}