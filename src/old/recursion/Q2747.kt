package old.recursion

import java.util.*


private val mem = Array(46) {0}
fun main() = with(Scanner(System.`in`)) {
    val input = nextInt()
    println(fibo(input))
}

private fun fibo(n: Int): Int {
    if (mem[n] != 0) return mem[n];
    if (n == 0) return 0;
    if (n == 1) return 1;
    mem[n] = fibo(n - 1) + fibo(n - 2)
    return mem[n]
}

