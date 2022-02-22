package thisIsCodingTest

class Meterialization {
    fun UDLR (n:Int, plan:String): IntArray {
        val board = Array(n+2){ IntArray(n+2){0}}

        var i = 1
        var j = 1
        val plans = plan.split(" ")

        for(p in plans){
            if(p == "R"){
                if(j + 1 > n) continue
                j+=1

                continue
            }

            if(p == "U"){
                if( i -1 < 1) continue
                i-=1
                continue
            }

            if(p == "L"){
                if(j-1 < 0) continue
                j-=1
                continue
            }

            if(p == "D"){
                if(i+1 > n) continue
                i+=1
                continue
            }
        }
        return intArrayOf(i,j)
    }

    fun time(n:Int): Int {
        var count = 0
        for(i in 0 .. n){
            for(j in 0 until 60){
                for (k in 0 until 60){
                    if("$i $j $k".contains("3")) count++
                }
            }
        }
        return count
    }
}