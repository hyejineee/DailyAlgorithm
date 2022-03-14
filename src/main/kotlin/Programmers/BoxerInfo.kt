package Programmers

data class BoxerInfo(
    val boxerNumber: Int,
    val weight: Int,
    val winningRate: Double,
    val numberOfWinsHeavier: Int
) : Comparable<BoxerInfo> {

    override fun compareTo(other: BoxerInfo): Int = when {
        winningRate != other.winningRate -> if (other.winningRate > winningRate) 1 else -1
        numberOfWinsHeavier != other.numberOfWinsHeavier -> other.numberOfWinsHeavier - numberOfWinsHeavier
        weight != other.weight -> other.weight - weight
        else -> boxerNumber - other.boxerNumber
    }
}