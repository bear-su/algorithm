package divide

import java.util.*

private var count = 0;
fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val r = nextInt()
    val c = nextInt()

    solve(N, r, c)
    println(count)
}

private fun solve(N: Int, R: Int, C: Int) {
    if (N == 0) return;

    val boardSize = 1 shl N; // (<< 연산)
    val half = boardSize / 2;

    if (R < half && C < half) {
        solve(N - 1, R, C)
    } else if (R < half && C >= half) {
        count += half * half;
        solve(N - 1, R, C - half)
    } else if (R >= half && C < half) {
        count += half * half * 2;
        solve(N - 1, R - half, C)
    } else {
        count += half * half * 3;
        solve(N - 1, R - half, C - half)
    }
}