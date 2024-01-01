package recursion

import java.util.*

private val mem = Array(10_001){0}
fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()

    val arr = Array(N){0}
    for (i in 0 until N) {
        arr[i] = nextInt()
    }

    Arrays.sort(arr)

    solution(arr, 0, 0, N, M)
}

private fun solution(arr: Array<Int>, L: Int, S: Int, N: Int, M: Int) {
    if (L == M) {
        for (i in 0 until M) {
            print("${mem[i]} ")
        }
        println()
    } else {
        for (i in S until N) {
            mem[L] = arr[i]
            solution(arr, L + 1, i + 1, N, M)
        }
    }
}