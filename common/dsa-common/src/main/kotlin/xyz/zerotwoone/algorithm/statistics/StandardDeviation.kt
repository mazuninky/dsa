package xyz.zerotwoone.algorithm.statistics

import kotlin.math.pow
import kotlin.math.sqrt

class StandardDeviationAlgorithm {
    var size = 0L
        private set

    var isInitialized = false
        private set

    var mean: Double = .0
        private set

    var standardDeviationSquared: Double = .0
        private set

    fun setup(items: Iterable<Int>) {
        if (isInitialized)
            throw IllegalStateException()

        mean = items.average()
        var sum = 0.0
        var elements = 0L
        items.forEach {
            sum += (it - mean).pow(2)
            ++elements
        }
        standardDeviationSquared = sum / elements
        size = elements

        isInitialized = true
    }

    fun process(item: Int) {
        if (!isInitialized)
            throw IllegalStateException()

        ++size
        mean = dynamicMean(mean, size, item)
        standardDeviationSquared = dynamicStandardDeviation(mean, standardDeviationSquared, size, item)
    }

    inline fun standardDeviation() = sqrt(standardDeviationSquared)

    inline fun sigmaBounds(): Pair<Double, Double> {
        val standardDeviation = standardDeviation()
        return Pair(mean - standardDeviation, mean + standardDeviation)
    }

    inline fun threeSigmaBounds(): Pair<Double, Double> {
        val standardDeviation = standardDeviation()
        return Pair(mean - 3 * standardDeviation, mean + 3 * standardDeviation)
    }

    private inline fun dynamicMean(lastMean: Double, n: Long, item: Int): Double =
            (n.minus(1) * lastMean + item) / n

    private inline fun dynamicStandardDeviation(mean: Double, lastDeviationSquared: Double, n: Long, item: Int) =
            (n.minus(2) * lastDeviationSquared + (item - mean).pow(2)) / n.minus(1)
}

/**
 * Подсчёт среднего арифметического по старому значению
 */
fun dynamicMean(lastMean: Double, n: Int, item: Int): Double =
        (n.minus(1) * lastMean + item) / n

/**
 * Подсчёт дисперсии по старому значению
 */
fun dynamicStandardDeviation(mean: Double, lastDeviation: Double, n: Int, item: Int) =
        sqrt((n.minus(2) * lastDeviation + (item - mean).pow(2)) / n.minus(1))

fun Iterable<Int>.standardDeviation(): Double {
    val mean = average()
    var sum = 0.0
    var size = 0
    forEach {
        sum += (it - mean).pow(2)
        ++size
    }
    return sqrt(sum / size)
}