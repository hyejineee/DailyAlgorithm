package Programmers

fun addNumberNotExist(numbers:IntArray):Int = (0..9).filterNot { it in numbers }.sum()