package old.binarysearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = Integer.parseInt(st.nextToken())
    val M = st.nextToken().toLong()

    val trees = Array<Long>(N, {0})
    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        trees[i] = st.nextToken().toLong()
    }

    Arrays.sort(trees)

    var left: Long = 1;
    var right: Long = trees.maxBy { it }
    var answer: Long = 0

    while (left <= right) {
        val mid = (left + right) / 2
        val enough = isEnough(trees, mid, M)

        if (!enough) {
            right = mid - 1
        } else {
            answer = mid
            left = mid + 1
        }
    }

    println(answer)
}

fun isEnough(trees: Array<Long>, h: Long, goal: Long): Boolean {
    var count: Long = 0
    for (tree in trees) {
        val diff = tree - h
        if (diff > 0) count += diff
    }
    return goal <= count
}