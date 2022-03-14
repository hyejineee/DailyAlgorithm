package codility

fun oddOccurrencesInArray(A: IntArray):Int {
    val sorted = A.toMutableList().sorted()
    val set = hashSetOf<Int>()

    for(i in sorted){
        if(set.contains(i)){
            set.remove(i)
        }else{
            set.add(i)
        }
    }

    // 왜 시간 복잡도가 n^2이지...
//    val g = MutableList
//
//    for(i in g){
//        if(i.value.size <=1) return i.key
//    }

    return  set.first()
}