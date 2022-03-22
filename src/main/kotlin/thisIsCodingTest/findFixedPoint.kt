package thisIsCodingTest

fun findFixedPoint(arr:IntArray):Int{

    var start = 0
    var end = arr.size-1

    while (start <= end){
        val mid = (start + end)/2

        if(arr[mid] == mid) return mid

        if(mid > arr[mid]){
            start = mid +1
        }else{
            end = mid -1
        }
    }

    return -1
}