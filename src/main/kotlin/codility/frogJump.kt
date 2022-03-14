package codility

fun flogJump(X:Int, Y:Int, D:Int):Int{
    return ((Y - X) / D) + if((Y - X)%D >0) 1 else 0
}