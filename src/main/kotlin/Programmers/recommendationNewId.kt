package Programmers

fun recommendationNewId(newId: String): String = newId
    .toLowerCase()
    .filter {
        it in '0'..'9' || it in charArrayOf('_', '-', '.') || it in 'a'..'z'
    }
    .let { step3(it) }
    .let { step4(it) }
    .let(step5)
    .let(step6)
    .let(step7)

fun step3(id: String): String {
    val temp = id.replace("..", ".")
    if (!temp.contains("..")) {
        return temp
    }
    return step3(temp)
}

fun step4(id: String): String {
    var temp = if (id.first() == '.') id.drop(1) else id
    temp = if (temp.isNotEmpty() && temp.last() == '.') temp.dropLast(1) else temp

    if (temp.isEmpty() || (temp.first() != '.' && temp.last() != '.')) {
        return temp
    }

    return step4(temp)
}

val step5 = { id: String ->
    if (id.isBlank() || id.isEmpty()) "a" else id
}

val step6 = { id: String ->
    if (id.length > 15)
        step4(id.substring(0, 15))
    else
        id
}

val step7 = { id: String ->
    var temp = id
    while (temp.length < 3) {
        temp = temp.plus(id.last())
    }
    temp
}



