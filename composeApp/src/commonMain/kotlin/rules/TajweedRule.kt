package rules

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import arabic.ArabicChar
import arabic.ArabicText
import arabic.Vowel
import kotlin.math.abs


interface TajweedRule {

    val color: Color
    val charSelectors: List<ArabicChar>
    val vowelSelectors: List<Vowel>
    val length get() = beforeVowelCheckers.size + afterVowelCheckers.size
    val beforeCharCheckers: Map<Int, List<ArabicChar>>
    val afterCharCheckers: Map<Int, List<ArabicChar>>
    val beforeVowelCheckers: Map<Int, List<Vowel>>
    val afterVowelCheckers: Map<Int, List<Vowel>>
    val selectedCharVowels: List<Vowel>


    fun searchRuleInArabicText(text: ArabicText): List<IntOffset> {

        val result = mutableListOf<IntOffset>()
        var textIndex = 0

        text.words.forEachIndexed { wordIndex, word ->
            word.chars.forEachIndexed wordLoop@{ charIndex, char ->
                textIndex++
                if (textIndex < length) return@wordLoop
                when {
                    (char.char in charSelectors.map { it.char } || char.vowels.any { it in vowelSelectors }) -> {
                        println("Found char: $char")
                        val beforeCharSet = getBeforeChars(text, wordIndex, charIndex)
                        val afterCharSet = getAfterChars(text, wordIndex, charIndex)
                        val beforeVowelSet = beforeCharSet.map { it.vowels }.flatten()
                        val afterVowelSet = afterCharSet.map { it.vowels }.flatten()
                        if (!isSelectionValid(
                                beforeCharSet = beforeCharSet,
                                afterCharSet = afterCharSet,
                                beforeVowelSet = beforeVowelSet,
                                afterVowelSet = afterVowelSet,
                                currentChar = char
                            )
                        ) return@wordLoop
                        result.add(IntOffset(wordIndex, charIndex))
                    }
                }
            }
        }
        return result
    }

    private fun getBeforeChars(text: ArabicText, wordIndex: Int, charIndex: Int): List<ArabicChar> {
        val word = text.words[wordIndex]
        val leftLength = beforeCharCheckers.size
        if (charIndex - leftLength < 0) {
            val newIndex = charIndex - leftLength
            if (text.words[wordIndex - 1].chars.size > newIndex) {
                val previousWord = text.words[wordIndex - 1]
                val beforeSet =
                    previousWord.chars.subList(previousWord.chars.size - newIndex, previousWord.chars.size) +
                            word.chars.subList(charIndex, word.chars.size)
                return beforeSet
            }
            return emptyList()
        }
        val beforeSet = text.words[wordIndex].chars.subList(charIndex - leftLength, charIndex)
        return beforeSet
    }

    private fun getAfterChars(text: ArabicText, wordIndex: Int, charIndex: Int): List<ArabicChar> {
        val word = text.words[wordIndex]
        val afterCharSize = afterCharCheckers.size
        if (charIndex + afterCharSize >= word.chars.size && text.words.size > wordIndex + 1) {
            val newIndex = abs(word.chars.size - charIndex - afterCharSize + 1)
            if (text.words[wordIndex + 1].chars.size > newIndex) {
                val nextWord = text.words[wordIndex + 1]
                val afterSet = word.chars.subList(charIndex + 1, word.chars.size) +
                        nextWord.chars.subList(0, newIndex)
                return afterSet
            }
            return emptyList()
        }
        if (charIndex + afterCharSize + 1 >= word.chars.size) return emptyList()
        val afterSet = text.words[wordIndex].chars.subList(charIndex + 1, charIndex + afterCharSize + 1)
        return afterSet
    }

    fun isBeforeCharSetValid(beforeSet: List<ArabicChar>): Boolean {
        beforeCharCheckers.forEach { (index, arabicChars) ->
            beforeSet.getOrNull(index)
                ?.let { char ->
                    arabicChars.find { it.char == char.char }
                        ?: return false
                } ?: return false
        }
        return true
    }

    fun isAfterCharSetValid(afterSet: List<ArabicChar>): Boolean {
        afterCharCheckers.forEach { (index, arabicChars) ->
            afterSet.getOrNull(index)
                ?.let { char ->
                    arabicChars.find { it.char == char.char }
                        ?: return false
                } ?: return false
        }
        return true
    }

    fun isBeforeVowelSetValid(beforeSetVowels: List<Vowel>): Boolean {
        beforeVowelCheckers.forEach { (index, vowels) ->
            beforeSetVowels.getOrNull(index)
                ?.let { vowel ->
                    vowels.find { it == vowel }
                        ?: return false
                } ?: return false
        }
        return true
    }

    fun isSelectedCharVowelsValid(arabicChar: ArabicChar): Boolean {
        selectedCharVowels.forEach { vowel ->
            arabicChar.vowels.find { selectedCharVowel -> selectedCharVowel == vowel } ?: return  false
        }
        return true
    }

    fun isAfterVowelSetValid(afterSetVowels: List<Vowel>): Boolean {
        afterVowelCheckers.forEach { (index, vowels) ->
            afterSetVowels.getOrNull(index)
                ?.let { vowel ->
                    vowels.find { it == vowel }
                        ?: return false
                }  ?: return false
        }
        return true
    }

    fun isSelectionValid(
        beforeCharSet: List<ArabicChar>,
        afterCharSet: List<ArabicChar>,
        beforeVowelSet: List<Vowel>,
        afterVowelSet: List<Vowel>,
        currentChar: ArabicChar
    ): Boolean {
        if (beforeCharSet.size < beforeCharCheckers.size || afterCharSet.size < afterCharCheckers.size) return false
        return isBeforeCharSetValid(beforeCharSet) &&
                isAfterCharSetValid(afterCharSet) &&
                isBeforeVowelSetValid(beforeVowelSet) &&
                isAfterVowelSetValid(afterVowelSet) &&
                isSelectedCharVowelsValid(currentChar)
    }
}

