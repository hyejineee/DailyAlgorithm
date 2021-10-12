package Programmers

fun maxAndMin(s: String) = run {
    val toInt = s.split(" ").map { it.toInt() }.sorted()
    "${toInt.first()} ${toInt.last()}"
}

