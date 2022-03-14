package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val s = readLine()
        var inbracket = false
        var temp = StringBuilder()
        var result = StringBuilder()

        for (i in s) {
            when (i) {
                '<' -> {
                    result.append(temp.reversed())
                    temp.clear()
                    inbracket = true
                    result.append('<')
                }
                '>' -> {
                    inbracket = false
                    result.append('>')
                }
                ' ' -> {
                    if(inbracket.not()){
                        result.append(temp.reversed())
                        result.append(" ")
                        temp.clear()
                    }else{
                        result.append(' ')
                    }
                }
                else -> {
                    if(inbracket){
                        result.append(i)
                    }else{
                        temp.append(i)
                    }
                }
            }
        }

        if(temp.length > 0){
            result.append(temp.reversed())
        }

        bw.write(result.toString())
        bw.flush()
        bw.close()
    }
}