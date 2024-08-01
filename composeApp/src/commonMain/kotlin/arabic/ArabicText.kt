package arabic

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.IntOffset
import rules.TajweedRule


data class ArabicText(
    val words: List<ArabicWord>,
    val rules: List<TajweedRule>
) {
    val length = words.sumOf { it.chars.size }


    companion object {
        val chars = listOf(
            'أ', 'ب', 'ت', 'ث', 'ج', 'ح', 'خ',
            'د', 'ذ', 'ر', 'ز', 'س', 'ش', 'ص',
            'ض', 'ط', 'ظ', 'ع', 'غ', 'ف', 'ق',
            'ك', 'ل', 'م', 'ن', 'ه', 'و', 'ي',
            'ء', 'ؤ', 'ئ', 'إ', 'ى', 'ة','إ'
        )
    }

    fun generateAnnotatingString(): AnnotatedString = buildAnnotatedString {
        val rulesSelectors = mutableMapOf<TajweedRule, List<IntOffset>>()
        rules.forEachIndexed { index, rule ->
            rulesSelectors[rule] = rule.searchRuleInArabicText(this@ArabicText)
        }

        words.forEachIndexed { i, word ->
            word.chars.forEachIndexed { j, char ->
                if (rulesSelectors.isEmpty()){
                    append(char.char + char.vowels.joinToString("") { it.toSymbol() })
                }
                else {
                    var isStyled = false
                    rulesSelectors.forEach { ruleSelector ->
                        val rule = ruleSelector.key
                        val ruleOffsets = ruleSelector.value
                        val offset = IntOffset(i, j)
                        if (offset in ruleOffsets) {
                            if (isStyled) return@forEach
                            isStyled = true
                            withStyle(style = SpanStyle(color = rule.color)) {
                                append(char.char + char.vowels.joinToString("") { it.toSymbol() })
                            }
                        }
                    }
                    if (!isStyled) {
                        append(char.char + char.vowels.joinToString("") { it.toSymbol() })
                    }
                }

            }
            append(" ")
        }

    }

}
