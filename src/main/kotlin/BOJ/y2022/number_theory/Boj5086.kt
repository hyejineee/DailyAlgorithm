package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        while (true) {
            val (n, m) = readLine().split(" ").map { it.toInt() }

            if (n == 0 && m == 0) System.exit(0)

            if(m % n ==0){
                println( "factor")
            }else if(n%m ==0){
                println("multiple")
            }else{
                println("neither")
            }
        }
    }
}

