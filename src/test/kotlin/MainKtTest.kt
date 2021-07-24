import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun bottomUp() {
        val n = 4
        val w = intArrayOf(4, 3, 2, 3)
        val v = intArrayOf(3, 2, 4, 4)
        val W = 6

        val result = bottomUp(n, w, v, W).toIntArray()

        println("Optimal Solution: ${result.contentToString()}")

        val expected = intArrayOf(3, 4)

        assertArrayEquals(expected, result.reversedArray())


    }
}