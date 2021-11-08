package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n,m ) = readLine().split(" ").map { it.toInt() }
        val groups = mutableListOf<Group>()

        (1..n).forEach {
            val groupName = readLine()
            val headcount = readLine().toInt()
            val members = mutableListOf<String>()
            (1..headcount).forEach {
                members.add(readLine())
            }

            members.sort()
            groups.add(Group(groupName, headcount, members))
        }

        (1..m).forEach {
            val name = readLine()

            when(readLine().toInt()){
                0-> {
                    groups.find { it.name == name }?.members?.forEach {
                        bw.write("$it \n")
                    }
                }
                else ->{
                    val find = groups.find { name in it.members }?.name
                    bw.write("$find\n")
                }
            }

        }

        bw.flush()
        bw.close()
    }
}

private data class Group(
    val name:String,
    val headcount :Int,
    val members : List<String>
)