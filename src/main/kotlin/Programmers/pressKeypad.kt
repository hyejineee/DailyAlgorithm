package Programmers

import kotlin.math.abs

fun pressKeypad(numbers: IntArray, hand: String): String {

    var r = 10
    var l = 12

    return numbers.map {
        val num = if (it == 0) 11 else it
        when (num % 3) {
            0 -> {
                //오른쪽
                r = num
                'R'
            }
            1 -> {
                //왼쪽
                l = num
                'L'
            }
            else -> {
                //가운데

                val rGap = abs(((r - num) / 3) + (r - num) % 3)
                val lGap = abs(((l - num) / 3) + (l - num) % 3)

                if (rGap == lGap) {
                    when (hand) {
                        "right" -> {
                            r = num
                            'R'
                        }
                        else -> {
                            l = num
                            'L'
                        }
                    }
                } else if (rGap > lGap) {
                    l = num
                    'L'
                } else {
                    r = num
                    'R'
                }

            }
        }
    }.joinToString("")
}