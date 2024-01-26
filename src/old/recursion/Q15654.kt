package old.recursion

import java.util.*

private val visited = Array(10_001) {false}
fun main() = with(Scanner(System.`in`)){
    val N = nextInt()
    val M = nextInt()

    val arr = Array(N) {0}
    val mem = Array(M) {0}
    for (i in 0 until N) {
        arr[i] = nextInt()
    }

    Arrays.sort(arr)

    solution(arr, mem, 0, N, M)
}

private fun solution(arr: Array<Int>, mem: Array<Int>, L: Int, N: Int, M: Int) {
    if (L == M) {
        for (i in 0 until M) {
            print("${mem[i]} ")
        }
        println()
    } else {
        for (i in 0 until N) {
            if (!visited[i]) {
                visited[i] = true
                mem[L] = arr[i]
                solution(arr, mem, L + 1, N, M)
                visited[i] = false
            }
        }
    }
}