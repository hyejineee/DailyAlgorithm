package thisIsCodingTest

import java.util.*

fun mukbangLive(food_times: IntArray, k: Long): Int {
    if (food_times.sum() <= k) return -1

    val q = PriorityQueue<IntArray>(compareBy({ it[1] }))

    for (i in food_times.indices) {
        q.add(intArrayOf(i + 1, food_times[i]))
    }

    var sumTime:Long = 0
    var previous = 0
    var remainFood = food_times.size

    while (sumTime + ((q.peek()[1]- previous)* remainFood) <=k){
        println(sumTime)
        val pop = q.poll()[1]
        sumTime += (pop - previous) * remainFood
        remainFood -=1
        previous = pop

        if(q.isEmpty()) break
    }

    val result = q.sortedBy { it[0] }
    return result[((k-sumTime) % remainFood).toInt()][0]
}

//import java.util.*
//class Solution {
//    fun solution(food_times: IntArray, k : Long) : Int {
//        val foodQueue = LinkedList(food_times.indices
//            .groupBy { food_times[it] }
//            .toSortedMap()
//            .toList())
//        var takingTime = 0L
//        var remainFoodCount = food_times.size
//        var lastEatenFoodTakingTime = 0
//        while(foodQueue.isNotEmpty()) {
//            val currentFood = foodQueue.peekFirst()
//            val nextTime : Long = takingTime + (currentFood.first - lastEatenFoodTakingTime) * remainFoodCount
//            if(nextTime > k) break
//            takingTime = nextTime
//            remainFoodCount -= currentFood.second.size
//            lastEatenFoodTakingTime = currentFood.first
//            foodQueue.removeFirst()
//        }
//        return if(foodQueue.isEmpty()) -1
//        else ArrayList<Int>().apply { foodQueue.forEach { it.second.forEach { add(it + 1) } } }.sorted()[((k - takingTime) % remainFoodCount).toInt()]
//    }
//}
//fun mukbangLive(food_times: IntArray, k: Long): Int {
//
//    var remainFoods = food_times.mapIndexed { index, i -> intArrayOf(index+1, i) }.toTypedArray()
//    var remain = k
//
//    while (remain >= 0) {
//
//        val rotate =( remain / remainFoods.size).toInt()
//
//        if(rotate > 0){
//            for (i in remainFoods.indices){
//                remainFoods[i][1] -= rotate
//            }
//            remain -= rotate * remainFoods.size
//            remainFoods = remainFoods.filter { it[1] >0 }.toTypedArray()
//            continue
//        }
//
//        println("${ (remainFoods.size * (remain/ remainFoods.size))}")
//        val index = (remainFoods.size * (remain/ remainFoods.size).toDouble()).toInt()
//        return remainFoods[index][0]
//    }
//    return 0
//}