package old.divide

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val A = nextLong()
    val B = nextLong()
    val C = nextLong()

    println(divide(A, B, C))
}

private fun divide(A: Long, B: Long, C: Long): Long {
    if (B == 1L) return A % C
    val half = divide(A, B / 2, C)
    if (B % 2 == 0.toLong()) {
        return (half * half) % C
    } else {
        return (((half * half) % C) * A)% C
    }
}

// 수학적 사전 지식
// 지수함수의 곱 = 2^n * 2^m = 2^(n+m)
// 나머지 연산의 분배법칙
// (A * B) % C = ((A % C) * (B % C))