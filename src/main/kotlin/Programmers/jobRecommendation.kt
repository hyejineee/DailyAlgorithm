package Programmers

fun jobRecommendation(table: Array<String>, languages: Array<String>, preference: IntArray): String =
    table.sorted().map {
        val info = it.split(" ")

        val t = languages.foldIndexed(0) { index, acc, s ->
            acc + ((info.indexOf(s).let { n -> if (n > 0) info.size - n else 0 }) * preference[index])
        }

        info[0] to t
    }.maxBy { it.second }?.first ?: ""

