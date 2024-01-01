package binarysearch

import java.util.*
import kotlin.random.Random.Default.nextInt

fun main() = with(System.`in`) {
    val N = nextInt()
    val M = nextInt()

    val arr = Array(N) { 0 }
    for (i in 0 until N) {
        arr[i] = nextInt()
    }

    Arrays.sort(arr)

    var left = 1
    var right = 10_000
    var answer = 100_001
    while (left <= right) {
        val mid = (left + right) / 2
        val day = getDay(arr, mid)
        if (day <= M) {
            right = mid - 1
            answer = Math.min(answer, mid)
        }
        else left = mid + 1
    }

    println(answer)


}

private fun getDay(arr: Array<Int>, money: Int): Int {
    var dayCount = 0
    var nowMoney = money;
    for (i in arr) {
        if (nowMoney < i) {
            dayCount++
            nowMoney = money;
        } else {
            nowMoney -= i
        }
    }
    return dayCount
}

// M번만 통장에서 돈을 빼서 쓰기로 하였다.
// K원으로 인출한다.
//  하루를 보낼 수 있으면 그대로 사용한다.
//  모자라면 통장에 집어넣고 다시 K원을 인출한다.

// 현우는 정확히 M번을 맞추고 싶다. 그래서 남은 금액이 그날 사용할 금액보다 많더라도 남은 금액은 통장에 집어넣고 K원을 인출할 수 있다.

// 입력: