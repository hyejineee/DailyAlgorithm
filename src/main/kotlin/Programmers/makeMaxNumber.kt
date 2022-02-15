package Programmers

fun makeMaxNumber(numbers: IntArray): String = numbers
    .map { it.toString() }
    .sortedDescending()
    .sortedWith(Comparator { o1, o2 ->
        (o2 + o1).compareTo(o1 + o2)
    })
    .joinToString("")
    .run {
        if(this.first() == '0') "0" else this
    }
