import kotlin.math.absoluteValue

fun main() {
    fun parse(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        input.map {
            val split = it.split("   ")
            left.add(split[0].toInt())
            right.add(split[1].toInt())
        }

        return Pair(left, right)
    }

    fun part1(input: List<String>): Int {
        val (left, right) = parse(input)
        left.sort()
        right.sort()

        return left.zip(right).fold(0) { acc, (a, b) ->
            acc + (b - a).absoluteValue
        }
    }

    fun part2(input: List<String>): Int {
        val (left, right) = parse(input)

        return left.fold(0) { acc, lValue ->
            val q = right.filter { it == lValue  }.size
            acc + q * lValue
        }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
