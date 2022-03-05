package Programmers

fun findRemainderIs1(n:Int):Int{
    val num = n-1
    for(i in 2..num){
        if(num % i == 0) return i
    }
    return num
}