package Programmers

import java.util.*

fun diskController(jobs:Array<IntArray>):Int{

    val sortedJobs = jobs.sortedWith(compareBy({it[0]},{it[1]}))

    val jobQueue = LinkedList(sortedJobs)
    val runTimeJobQueue = PriorityQueue<IntArray>(kotlin.Comparator { o1, o2 -> o1[1].compareTo(o2[1]) })

    runTimeJobQueue.add(jobQueue.poll())

    var finishTime = 0
    var totalWorkingTime = 0
    while (jobQueue.isNotEmpty() || runTimeJobQueue.isNotEmpty()){

        println("남은 작업: ${jobQueue.map { it.toList() }}, runTime작업 : ${runTimeJobQueue.map { it.toList() }}")

        if(runTimeJobQueue.isNotEmpty()){
            val (requestTime, workingTime) = runTimeJobQueue.poll()
            val waitTime = if(finishTime - requestTime > 0) finishTime - requestTime else 0
            println("작업T: $workingTime, 요청T:$requestTime, 대기T:$waitTime")

            totalWorkingTime += workingTime + waitTime
            finishTime = requestTime + (workingTime + waitTime)
            println("전체 작업T: ${workingTime + waitTime}, 완료시점:$finishTime")

            while (true){
                val peek = jobQueue.peek()?: break
                if(peek[0] <= finishTime){
                    runTimeJobQueue.add(jobQueue.poll())
                }else{
                    break
                }
            }
            continue
        }

        runTimeJobQueue.add(jobQueue.poll())
    }

    println("finishTime : $finishTime, totalWorkingTime : $totalWorkingTime")


    return totalWorkingTime / jobs.size
}