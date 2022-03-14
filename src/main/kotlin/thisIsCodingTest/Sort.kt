package thisIsCodingTest

class Sort {

    fun topDown(numbers: IntArray): IntArray {
        return numbers.sortedArrayDescending()
    }

    fun printStudents(students: Array<String>) = students
        .map {
            val (name, score) = it.split(" ")
            name to score
        }
        .sortedBy { it.second }
        .joinToString(" ") { it.first }

    fun swapElementTowArrays(arr1:IntArray, arr2:IntArray, k:Int):Int{

        arr1.sort()
        arr2.sortDescending()

        for(i in 0 until k){
            arr1[i] = arr2[i]
        }

        return arr1.sum()
    }
}