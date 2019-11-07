package xyz.mazuninky.dsa.algorithm

import xyz.mazuninky.dsa.base.KList
import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.math.truncate

fun <T> KList<T>.jumpSearch(item: T, comparator: Comparator<T>): Boolean{
    val blockSize = truncate(sqrt(size.toDouble())).roundToInt()

    val blocks = floor((size.toDouble() / blockSize)).roundToInt()

    for (blockNum in 0..blocks) {
        val compare = comparator.compare(item, get(blockNum * blockSize))
//        if(compare > 0)

    }

    return false
}


fun <T> KList<T>.nextBlock(item: T, comparator: Comparator<T>) {

}
