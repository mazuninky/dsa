package xyz.mazuninky.dsa.algorithm

import xyz.mazuninky.dsa.base.KList
import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.math.truncate

/**
 * Jump search
 * O(sqrt(n))
 */
fun <T> KList<T>.jumpSearch(item: T, comparator: Comparator<T>): Boolean {
    val blockSize = truncate(sqrt(size.toDouble())).roundToInt()

    val blocks = floor((size.toDouble() / blockSize)).roundToInt()

    return nextBlock(item, comparator, 0, blockSize, blocks)
}

fun <T> KList<T>.nextBlock(item: T, comparator: Comparator<T>, blockNum: Int, blockSize: Int, blocks: Int): Boolean {
    if (blockNum == blockSize)
        return false

    val compare = comparator.compare(item, get(blockNum * blockSize))

    if (compare == 0)
        return true

    if (compare > 0) {
        if (blockNum != blocks - 1) {
            return nextBlock(item, comparator, blockNum + 1, blockSize, blocks)
        } else {
            for (i in (blockNum * blockSize + 1) until ((blockNum + 1) * blockSize)) {
                if (comparator.compare(item, get(i)) == 0) {
                    return true
                }
            }
        }
    } else {
        if (blockNum == 0)
            return false

        for (i in (blockNum * blockSize - 1) downTo (blockNum * blockSize + 1)) {
            if (comparator.compare(item, get(i)) == 0) {
                return true
            }
        }
    }

    return false
}
