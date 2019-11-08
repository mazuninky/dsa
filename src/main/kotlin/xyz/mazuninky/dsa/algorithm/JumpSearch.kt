package xyz.mazuninky.dsa.algorithm

import xyz.mazuninky.dsa.base.DSAList
import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.math.truncate

/**
 * Jump search
 * O(sqrt(n))
 */
fun <T> DSAList<T>.jumpSearch(item: T, comparator: Comparator<T>): Boolean {
    // Calculate block size as an sqrt(n), where n is the size of the list
    val blockSize = truncate(sqrt(size.toDouble())).roundToInt()

    // Calculate a total block count
    val blocks = floor((size.toDouble() / blockSize)).roundToInt()

    return nextBlock(item, comparator, 0, blockSize, blocks)
}

fun <T> DSAList<T>.nextBlock(item: T, comparator: Comparator<T>, blockNum: Int, blockSize: Int, blocks: Int): Boolean {
    if (blockNum == blockSize)
        return false

    // Compare item with the first in a block element
    val compare = comparator.compare(item, get(blockNum * blockSize))

    // item == first
    if (compare == 0)
        return true

    // item > first
    if (compare > 0) {
        // If it isn't the last block
        if (blockNum != blocks - 1) {
            return nextBlock(item, comparator, blockNum + 1, blockSize, blocks)
        } else {
            for (i in (blockNum * blockSize + 1) until ((blockNum + 1) * blockSize)) {
                // item < list[i]
                if (comparator.compare(item, get(i)) < 0) {
                    return false
                }

                // item == list[i]
                if (comparator.compare(item, get(i)) == 0) {
                    return true
                }
            }
        }
    } else {
        if (blockNum == 0)
            return false

        for (i in (blockNum * blockSize - 1) downTo (blockNum * blockSize + 1)) {
            val compareResult = comparator.compare(item, get(i))

            // item > list[i]
            if (compareResult > 0) {
                return false
            }

            // item == list[i]
            if (compareResult == 0) {
                return true
            }
        }
    }

    return false
}
