package Programmers

fun minRectangle(sizes: Array<IntArray>):Int {
    sizes.forEach { it.sort() }
    return (sizes.maxBy { it[0] }?.first()?:0) * (sizes.maxBy { it[1] }?.last()?:0)
}