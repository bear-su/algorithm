package old.binarysearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val (C, houses) = input() // C: 공유기 설치 개수, houses: 집 정보

    Arrays.sort(houses)

    var left = 0
    var right = 1_000_000_000
    var answer = 0
    while (left <= right) {
        val mid = (left + right) / 2
        val count = putRouters(houses, mid)
        if (count >= C) {
            answer = Math.max(answer, mid);
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(answer)

}

private fun input(): Pair<Int, Array<Int>> {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val C = st.nextToken().toInt()

    val arr = Array(N, { 0 })
    for (i in 0 until N) {
        arr[i] = br.readLine().toInt()
    }

    return Pair(C, arr)
}

fun putRouters(arr: Array<Int>, length: Int): Int {
    var count = 1;
    var previousPos = arr[0];
    for (i in 1 until arr.size) {
        if (arr[i] - previousPos >= length) {
            count++
            previousPos = arr[i]
        };
    }

    return count;
}
