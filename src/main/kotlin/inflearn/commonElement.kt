package inflearn

fun commonElement(arr1 : IntArray, arr2 : IntArray) : IntArray{
    val sorted1 = arr1.sorted()
    val sorted2 = arr2.sorted()

    var p1 = 0
    var p2 = 0
    val result = mutableListOf<Int>()

    while (p1 < arr1.size && p2<arr2.size){
        val e1 = sorted1[p1]
        val e2 = sorted2[p2]

        if(e1 == e2){
            result.add(e1)
            p1++
            p2++
            continue
        }

        if(e1 < e2){
            p1++
        }else{
            p2++
        }
    }

    return  result.toIntArray()
}