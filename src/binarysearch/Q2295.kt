package binarysearch

import java.util.*
import kotlin.collections.HashSet

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    var arr = Array<Int>(N, {0})
    for (i in 0 until N) {
        arr[i] = nextInt()
    }

    var set = HashSet<Int>()
    for (i in 0 until N) {
        for (j in i until N) {
            set.add(arr[i] + arr[j])
        }
    }

    var answer = -1;
    for (i in 0 until  N) {
        for (j in 0 until N) {
            val target = arr[i] - arr[j]
            if (set.contains(target)) {
                answer = Math.max(answer, arr[i])
            }
        }
    }

    println(answer)
}