package rules

import androidx.compose.ui.graphics.Color
import arabic.ArabicChar
import arabic.Vowel

class Ghonnah(
    override val color: Color,
) : TajweedRule {
    override val charSelectors: List<ArabicChar> = listOf(ArabicChar('ن'), ArabicChar('م'))
    override val vowelSelectors: List<Vowel> = emptyList()
    override val beforeCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
    override val beforeVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
    override val afterCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
    override val afterVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
    override val selectedCharVowels: List<Vowel> = listOf(Vowel.SHADDA)

}