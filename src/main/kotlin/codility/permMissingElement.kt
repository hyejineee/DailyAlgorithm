package codility

fun permMissingElement(A:IntArray):Int{

    val record = IntArray(A.size +2){
        if(it == 0) Int.MAX_VALUE
        else 0
    }

    A.forEach {
        record[it] = 1
    }

    return record.indexOf(0)
}