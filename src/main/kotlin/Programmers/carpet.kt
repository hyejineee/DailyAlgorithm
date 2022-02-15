package Programmers

fun carpet(brown:Int, red:Int):IntArray{
    val aliquots = findAliquot(brown + red)

    var wIndex = aliquots.size /2

    return if(aliquots.size % 2 ==0){
        var hIndex = wIndex -1

        while ((aliquots[wIndex] *2) + ((aliquots[hIndex]-2)*2) != brown){
            wIndex +=1
            hIndex-=1
        }
        intArrayOf(aliquots[wIndex], aliquots[hIndex])
    }else{
        intArrayOf(aliquots[wIndex], aliquots[wIndex])
    }
}

private fun findAliquot(num:Int):MutableList<Int>{
    val aliquots = mutableListOf<Int>()
    for(i in 1..num){
        if(num % i == 0){
            aliquots.add(i)
        }
    }
    return aliquots
}