package Programmers

fun speedCamera(routes:Array<IntArray>): Int {
    val sorted = routes.sortedBy { it[1] }
    var answer = 0
    var index = 0
    val check = Array(routes.size){false}

    while (check.all { it }.not()){
        answer +=1

        for(i in index until routes.size){
            if(routes[index][1] !in routes[i][0]..routes[i][1]){
                index = i
                break
            }else{
                check[i] = true
            }
        }
    }

    return answer
}