package Programmers.y2022._1104

fun 두_큐_합_같게_만들기(queue1: IntArray, queue2: IntArray): Int {
    val total:Long = sum(queue1) + sum(queue2)
    val half : Long = total /2

    if (total % 2 != 0.toLong()) return -1;
    if(queue1.any { it >half } || queue2.any { it > half }) return -1

    var count = 0
    var sum1:Long = sum(queue1)
    var sum2:Long = sum(queue2)

    val merge = queue1 + queue2 + queue1 + queue2
    var s1 = 0
    var s2 = queue1.size

    while (sum1 != half){
        if(s2 > merge.size || s1 > merge.size) return -1

        if(sum1 > sum2){
            val p = merge[s1].toLong()

            sum1 -= p
            sum2 += p
            s1++
        }else{
            val p = merge[s2].toLong()

            sum1 += p
            sum2 -= p
            s2++
        }
        count ++
    }
    return count
}

fun sum(arr : IntArray) : Long = arr.fold(0.toLong()) { acc, cur -> acc + cur }
