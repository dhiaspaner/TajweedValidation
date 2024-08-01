package rules

import androidx.compose.ui.graphics.Color
import arabic.ArabicChar
import arabic.Vowel

//class TakhimRaWithFatha(override val color: Color) : TajweedRule {
//    override val charSelectors: List<ArabicChar> = listOf(ArabicChar('ر'))
//    override val afterCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
//    override val beforeCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
//    override val selectedCharVowels: List<Vowel> = listOf(Vowel.FATHA)
//    override val vowelSelectors: List<Vowel> = emptyList()
//    override val beforeVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
//    override val afterVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
//}
//
//class TafkhimRaWithSukunAndFatehaBefore(override val color: Color) : TajweedRule {
//    override val charSelectors: List<ArabicChar> = listOf(ArabicChar('ر'))
//    override val afterCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
//    override val beforeCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
//    override val selectedCharVowels: List<Vowel> = listOf(Vowel.SUKUN)
//    override val vowelSelectors: List<Vowel> = emptyList()
//    override val beforeVowelCheckers: Map<Int, List<Vowel>> = mapOf(
//        0 to listOf(Vowel.FATHA)
//    )
//    override val afterVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
//}
//
//class TafkhimRaWithSukunAndSukunBeforeAndFateh(override val color: Color) : TajweedRule {
//    override val charSelectors: List<ArabicChar> = listOf(ArabicChar('ر'))
//    override val afterCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
//    override val beforeCharCheckers: Map<Int, List<ArabicChar>> = emptyMap()
//    override val selectedCharVowels: List<Vowel> = listOf(Vowel.SUKUN)
//    override val vowelSelectors: List<Vowel> = emptyList()
//    override val beforeVowelCheckers: Map<Int, List<Vowel>> = mapOf(
//        0 to listOf(Vowel.SUKUN),
//        1 to listOf(Vowel.FATHA)
//    )
//    override val afterVowelCheckers: Map<Int, List<Vowel>> = emptyMap()
//}