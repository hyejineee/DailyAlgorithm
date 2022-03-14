package Programmers

class SkillCheck1{

    fun problem1(numbers: IntArray): IntArray {
        return numbers.foldIndexed(mutableSetOf<Int>()){ index, acc, i ->
            for(j in index+1 until numbers.size){
                acc.add(i+numbers[j])
            }
            acc
        }.sorted().toIntArray()
    }

    fun problem2(numbers: IntArray): Int {
        return IntArray(10){ it }.filter { it !in numbers}.sum()
    }

}