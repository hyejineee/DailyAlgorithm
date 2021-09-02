package Programmers

fun stringCompression(s: String): Int = (1..s.length / 2).map {
    val size = compressionBy(it, s, s.substring(0, it))
    size
}.minByOrNull { it } ?: 1


fun compressionBy(
    compressionSize: Int, s: String, target: String, count: Int = 0, compressed: String = "", index: Int = 0,
): Int {

    if (index >= s.length) {
        return compressed.plus(if (count > 1) "${count}${target}" else target).length
    }

    val endIndex = if (index + compressionSize >= s.length) s.length else index + compressionSize
    val currentWord = s.substring(index, endIndex)

    return if (target == currentWord) {
        compressionBy(compressionSize, s, target, count + 1, compressed, index + compressionSize)
    } else {
        val new = compressed.plus(if (count > 1) "${count}${target}" else target)
        compressionBy(compressionSize, s, currentWord, 1, new, index + compressionSize)
    }
}