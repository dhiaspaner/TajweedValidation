package rules

import androidx.compose.ui.graphics.Color
import arabic.ArabicChar
import arabic.Vowel

class Idhehar(override val color: Color) : TajweedRule {

    override val charSelectors: List<ArabicChar> = listOf(ArabicChar('ن'))
    override val vowelSelectors: List<Vowel>  = listOf(Vowel.TANWEENFATH,Vowel.TANWEENDHAM,Vowel.TANWEENKASR)
    override val beforeCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
    override val beforeVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
    override val afterVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
    override val afterCharCheckers: Map<Int, List<ArabicChar>> = mapOf(
        0 to listOf(
            ArabicChar('ء'),
            ArabicChar('أ'),
            ArabicChar('إ'),
            ArabicChar('ه'),
            ArabicChar('ع'),
            ArabicChar('غ'),
            ArabicChar('ح'),
            ArabicChar('خ'),
        )
    )
    override val selectedCharVowels: List<Vowel> = emptyList()

}