import java.lang.Integer.max

fun main(args: Array<String>) {
    val n = 10
    val w = intArrayOf(85, 26, 48, 21, 22, 95, 43, 45, 55, 52)
    val v = intArrayOf(79, 32, 47, 18, 26, 85, 33, 40, 45, 59)
    val W = 140

    val result = bottomUp(n, w, v, W).toIntArray()

    println(result.reversedArray().contentToString())
}

fun bottomUp(n: Int, w: IntArray, v: IntArray, W: Int): MutableList<Int> {
    val V = Array(n + 1) { IntArray(W + 1) }
    for (i in 1 until n + 1) {
        for (x in 0 until W + 1) {
            val j = x - w[i - 1]
            if (j < 0) {
                V[i][x] = max(V[i - 1][x], 0)
            } else {
                V[i][x] = max(V[i - 1][x], V[i - 1][j] + v[i - 1])
            }
        }
    }

    V.forEach { array -> println(array.contentToString()) }

    var i = n
    var j = W
    val s = mutableListOf<Int>()
    while (i > 0 && j > 0) {
//        if (V[i][j] == V[i - 1][j]) {
//            i -= 1
//        } else {
//            s.add(i)
//            j -= w[i - 1]
//        }
        if (V[i][j] > V[i - 1][j]) {
            s.add(i)
            j -= w[i - 1]
        } else {
            i -= 1
        }
    }
    return s
}