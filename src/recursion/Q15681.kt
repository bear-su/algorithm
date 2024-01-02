package recursion

import java.util.*
import javax.swing.text.html.HTML.Attribute.N


private lateinit var mem: Array<Int>

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val R = nextInt()
    val Q = nextInt()

    val trees = ArrayList<ArrayList<Int>>()
    for (i in 0 .. N) {
        trees.add(ArrayList<Int>())
    }

    for (i in 0 until N - 1) {
        val a = nextInt()
        val b = nextInt()
        trees[a].add(b)
        trees[b].add(a);
    }

    mem = Array(N + 1) {0}
    getSubTree(trees, R, -1)


    val answer = StringBuilder()
    for (i in 0 until Q) {
        val input = nextInt()
        answer.append(mem[input]).append("\n")
    }

    println(answer.toString())
}

private fun getSubTree(trees: List<List<Int>>, R: Int, previous: Int): Int {

    var count = 1
    for (child in trees[R]) {
        if (child != previous) {
            count += getSubTree(trees, child, R)
        }
    }

    mem[R] = count
    return count;
}