package thisIsCodingTest

fun compressString(s: String): Int {
    if (s.length == 1) return 1

    return if(s.length == 1) 1 else (1..s.length / 2).map {
        val size = compress(it, s)
        println(size)
        size
    }.minOrNull() ?: -1
}

private fun compress(unit: Int, s: String): Int {
    var ch = s.substring(0, unit)
    var count = 1
    val sb = StringBuilder()

    for (i in unit..s.length step unit) {

        if (i + unit > s.length) {
            if (count == 1) sb.append(ch) else sb.append("${count}${ch}")
            sb.append(s.substring(i, s.length))
            break
        }

        val curCh = s.substring(i, i + unit)

        if (curCh == ch) {
            count++
        } else {
            if (count == 1) sb.append(ch) else sb.append("${count}${ch}")
            ch = curCh
            count = 1
        }
    }

    println("unit:$unit ${sb.toString()}")
    return sb.length
}