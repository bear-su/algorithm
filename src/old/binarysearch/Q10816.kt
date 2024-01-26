package old.binarysearch

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val sangenMap = HashMap<Int, Int>()
    for (i in 0 until N) {
        val input = nextInt();
        sangenMap.put(input, sangenMap.getOrDefault(input, 0) + 1)
    }

    val M = nextInt()
    val sb = StringBuilder()
    for (i in 0 until M) {
        val input = nextInt();
        sb.append(sangenMap.getOrDefault(input, 0)).append(" ")
    }

    println(sb)
}