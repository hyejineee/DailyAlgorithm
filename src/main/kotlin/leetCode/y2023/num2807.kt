package leetCode.y2023

import kotlin.math.max
import kotlin.math.min


class ListNode(var `val` : Int){
    var next : ListNode? = null
}

fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    var curNode = head

    while (true){
        curNode ?: break

        val num1 = curNode.`val`
        val num2 = curNode.next?.`val` ?: break

        val newNode = ListNode(gcd(max(num1, num2), min(num1, num2)))

        newNode.next = curNode.next
        curNode.next = newNode
        curNode = newNode.next
    }

    return head
}


// 유클리드 호제 - 최대 공약수 구하기
fun gcd(a : Int, b : Int):Int{
    var num1 = a
    var num2 = b

    while (true){
        val r = num1 % num2

        if(r == 0) return num2

        num1 = num2
        num2 = r
    }
}

