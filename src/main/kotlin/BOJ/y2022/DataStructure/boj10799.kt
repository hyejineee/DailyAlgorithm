package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val ironBar = readLine()
    val stack = Stack<Char>()
    var count = 0

    for (i in ironBar.indices) {

        when (ironBar[i]) {
            '(' -> { stack.push(ironBar[i]) }
            else -> {
                if (stack.isNotEmpty()) {
                    stack.pop()

                    if(ironBar[i-1] =='('){
                        count += stack.size
                        continue
                    }

                    count++
                }

            }
        }
    }
    print(count)
}
