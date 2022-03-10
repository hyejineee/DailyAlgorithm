package thisIsCodingTest

import java.util.*
import kotlin.math.max
import kotlin.math.min

fun change(n: Int): Int {
    var remain = n
    val changes = intArrayOf(500, 100, 50, 10)
    var count = 0

    for (i in changes) {
        if (remain / i > 0) {
            count += (remain / i)
            remain %= i

        }
    }

    return count
}

fun lawOfLargeNumber(m: Int, k: Int, numbers: IntArray): Int {
    numbers.sortDescending()

    val max = numbers[0]
    val second = numbers[1]
    val count = (m / k) * k

    return (count * max) + ((m - count) * second)
}

fun numberCardGame(cards: Array<IntArray>): Int = cards.map {
    it.sort()
    it[0]
}.maxBy { it } ?: -1

fun untilBecomes1(n: Int, k: Int): Int {
    var become = n
    var count = 0

    while (true) {
        if (become % k == 0) become /= k else become -= 1
        count++
        if (become == 1) break
    }

    return count
}

fun adventurersGuide(n: Int, fears: IntArray): Int {
    val check = BooleanArray(fears.size) { false }
    fears.sort()
    var count = 0
    for (i in fears.indices) {
        val members = mutableListOf<Int>()

        for (j in 0..i) {
            if (fears[j] <= fears[i] && check[j].not()) {
                members.add(j)
            }
        }

        if (members.size >= fears[i]) {
            members.forEach {
                check[it] = true
            }
            count++
        }

    }
    return count
}

fun multiplyOrAdd(nums: String): Int {

    val ops = mutableListOf<Char>()
    val numbers = nums.map { Character.getNumericValue(it)}

    for (i in numbers.indices) {
        if (i == numbers.size - 1){
            ops.add(Char.MAX_VALUE)
            break
        }

        ops.add(if (numbers[i] > 0) '*' else '+')
    }

    var result = numbers[0]
    for (i in 1 until nums.length){
        val op = ops[i-1]
        when(op){
            '*' -> result *=numbers[i]
            else -> result += numbers[i]
        }
    }

    return result
}

fun flipString(s:String):Int{

    var cur = s.first()
    var zeroCount = 0
    var oneCount = 0

    for(i in s.indices){
        if(cur == s[i]) continue

        if(cur == '0') zeroCount++ else oneCount++
        cur = s[i]
    }

    if(s.last() == cur && cur =='0') zeroCount++ else oneCount++

    return min(zeroCount, oneCount)
}

fun notMadeMoney(n:Int,units:IntArray):Int{
    var target = 1
    units.sort()

    for(i in units){
        println("target :$target, i:$i")
        if(target<i){
            break
        }
        target+=i
    }
    return target
}
