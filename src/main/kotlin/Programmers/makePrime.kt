package Programmers

fun makePrime(nums:IntArray):Int{
    var count = 0
    for(i in nums.indices){
        for(j in i+1 until nums.size){
            for(k in j+1 until nums.size){
                if((nums[i] + nums[j] + nums[k]).isPrime()) {
                    count++
                }
            }
        }
    }
    return count
}

private fun Int.isPrime(): Boolean {
    var i =2
    while (i*i <= this){
        if(this%i == 0) return false
        i++
    }
    return true
}