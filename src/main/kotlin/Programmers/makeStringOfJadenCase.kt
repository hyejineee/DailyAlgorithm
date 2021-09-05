package Programmers

fun makeStringOfJadenCase(s: String): String = s.split(" ").map {
    if (it.isBlank() || it.isEmpty()) return@map it

    if (it.first().isLetter()) {
        it.first().toUpperCase().plus(it.substring(1, it.length).toLowerCase())
    } else {
        it.first().plus(it.substring(1, it.length).toLowerCase())
    }
}.joinToString(" ")
