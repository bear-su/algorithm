package old.binarysearch

import java.util.*
import kotlin.collections.HashSet


fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()

    nextLine()

    val s = HashSet<String>()
    for (i in 1.. N)
        s.add(nextLine())

    var count = 0;
    for (i in 1 .. M) {
        val input = nextLine()
        if (s.contains(input)) count++;
    }

    println(count)

}
