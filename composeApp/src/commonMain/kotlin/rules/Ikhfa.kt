package rules

import androidx.compose.ui.graphics.Color
import arabic.ArabicChar
import arabic.Vowel

class Ikhfa (override val color: Color) : TajweedRule {
    override val rightLength: Int = 1
    override val leftLength: Int = 0
    override val charSelectors: List<ArabicChar> = listOf(ArabicChar('ن'))
    override val vowelSelectors: List<Vowel> = listOf(Vowel.TANWEENFATH, Vowel.TANWEENDHAM, Vowel.TANWEENKASR)
    override val beforeCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
    override val beforeVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
    override val afterCharCheckers: Map<Int, List<ArabicChar>> = mapOf(
        0 to listOf(
            ArabicChar('ص'),
            ArabicChar('ذ'),
            ArabicChar('ث'),
            ArabicChar('ك'),
            ArabicChar('ج'),
            ArabicChar('ش'),
            ArabicChar('ق'),
            ArabicChar('س'),
            ArabicChar('د'),
            ArabicChar('ط'),
            ArabicChar('ز'),
            ArabicChar('ف'),
            ArabicChar('ت'),
            ArabicChar('ظ'),
        )
    )
    override val afterVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
    override val selectedCharVowels: List<Vowel> = emptyList()
}