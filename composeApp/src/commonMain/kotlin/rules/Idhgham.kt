package rules

import androidx.compose.ui.graphics.Color
import arabic.ArabicChar
import arabic.Vowel

class Idhgham(override val color: Color) : TajweedRule {
    override val rightLength: Int = 1
    override val leftLength: Int = 0
    override val charSelectors: List<ArabicChar> = listOf(ArabicChar('ن'))
    override val vowelSelectors: List<Vowel> = listOf(Vowel.TANWEENFATH, Vowel.TANWEENDHAM, Vowel.TANWEENKASR)
    override val beforeCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
    override val beforeVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
    override val afterCharCheckers: Map<Int, List<ArabicChar>> = mapOf(
        0 to listOf(
            ArabicChar('ي'),
            ArabicChar('ر'),
            ArabicChar('م'),
            ArabicChar('ل'),
            ArabicChar('و'),
            ArabicChar('ن'),
        )
    )
    override val afterVowelCheckers: Map<Int, List<Vowel>> = emptyMap()

    override val selectedCharVowels: List<Vowel> = emptyList()


}