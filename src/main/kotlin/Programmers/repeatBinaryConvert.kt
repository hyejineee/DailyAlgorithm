package Programmers

fun repeatBinaryConvert(s: String): IntArray = convert(s, 0, 0)

fun convert(x: String, countOfConvert: Int, deleted: Int): IntArray = when {
    x == "1" -> intArrayOf(countOfConvert, deleted)
    else -> convert(
        Integer.toBinaryString(x.replace("0", "").length),
        countOfConvert + 1,
        deleted + x.count { it == '0' }
    )
}
