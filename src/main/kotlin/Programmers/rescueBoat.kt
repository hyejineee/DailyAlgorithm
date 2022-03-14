package Programmers

fun rescueBoat(people:IntArray, limit: Int): Int {

    people.sort()
    var start =0
    var end = people.size -1
    var count =0

    while (start<=end){
        count++
        if(people[start] + people[end] <= limit){
            start +=1
        }
        end -=1
    }

    return count
}