package thisIsCodingTest

fun chooseBowlingBall(n:Int, balls:IntArray): Int {
//    val list = balls.toList()
//    var sum = 0
//    for(i in 0 until n){
//        sum += list.subList(i+1, n).count { it != balls[i] }
//    }

    val m = balls.maxOrNull()?:-1

    val ws = IntArray(11){0}
    balls.forEach { ws[it] ++ }
    var sum = 0
    var remain = n
    for (i in 1 ..m){
        remain -= ws[i]
        sum += ws[i] * remain
    }
    return sum
}