package utils

import arabic.ArabicChar


fun List<ArabicChar>.selectIfIsBefore(selectors: List<Char>, checkers: List<Char>): List<Int> {
    var lastChar = firstOrNull() ?: return  emptyList()
    val matchedIndices = mutableListOf<Int>()
    for (i in 1 until size) {
        if (lastChar.char in selectors && this[i].char in checkers) {
            matchedIndices.add(i - 2)
        }
        if (this[i].char != ' ' ) lastChar = this[i]
    }
    return matchedIndices
}

fun String.selectIfIsAfter(selectors: List<Char>, checkers: List<Char>): List<Int> {
    val matchedIndices = mutableListOf<Int>()
    for (i in 0 until length - 1) {
        if (this[i] in checkers && this[i + 1] in selectors) {
            matchedIndices.add(i)
        }
    }
    return matchedIndices
}

fun String.selectIfIsBetween(selectors: List<Char>, checkers: List<Char>): List<Int> {
    val matchedIndices = mutableListOf<Int>()
    for (i in 1 until length - 1) {
        if (this[i] in selectors && this[i - 1] in checkers && this[i + 1] in checkers) {
            matchedIndices.add(i)
        }
    }
    return matchedIndices
}



