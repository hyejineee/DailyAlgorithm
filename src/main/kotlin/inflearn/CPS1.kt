package inflearn

fun cps1(arr : IntArray, m : Int): Int {
    var p1 = 0
    var p2 = 0

    var count = 0
    while (p2 < arr.size){
        val sum = arr.slice(p1..p2).reduce { acc, i -> acc+i }

        if(sum == m){
            count++
            p1++
            continue
        }

        if(sum < m){
            p2++
        }else{
            p1++
        }
    }

    return count
}