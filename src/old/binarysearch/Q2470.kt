package old.binarysearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())
    val st = StringTokenizer(br.readLine())

    val arr = Array(N, {0})
    for (i in 0 until N) {
        arr[i] = Integer.parseInt(st.nextToken())
    }

    Arrays.sort(arr)

    var answer = abs(arr[0] + arr[1])
    var min = arr[0]
    var max = arr[1]
    for (i in 0 until N) {
        var left = i + 1
        var right = N - 1;
        while (left <= right) {
            val mid = (left + right) / 2
            val sum = arr[i] + arr[mid];


            val sumAbs = abs(sum)
            if (answer > sumAbs) {
                answer = sumAbs
                min = arr[i]
                max = arr[mid]
            }

            // 정답 리턴하면 된다.
            if (sum == 0) {
                min = arr[i]
                max = arr[mid]
                break
            }

            if (sum < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    println("$min $max")
}