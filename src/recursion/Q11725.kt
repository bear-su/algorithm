package recursion

import java.util.Scanner

private val mem = Array(100_001){0}

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()


    val arr = ArrayList<ArrayList<Int>>()
    for (i in 0 .. N) {
        arr.add(ArrayList<Int>())
    }

    for (i in 0 until N - 1) {
        val a = nextInt()
        val b = nextInt()
        arr[a].add(b)
        arr[b].add(a)
    }


    mem[1] = -1
    solution(arr, 1)
    for (i in 2 .. N) {
        println(mem[i])
    }
}

private fun solution(arr: List<List<Int>>, currentTree: Int) {
    for (nextTree in arr[currentTree]) {
        if (mem[nextTree] == 0) {
            mem[nextTree] = currentTree
            solution(arr, nextTree)
        }
    }
}