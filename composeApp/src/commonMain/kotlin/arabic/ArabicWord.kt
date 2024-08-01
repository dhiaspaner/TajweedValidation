package arabic

import androidx.compose.ui.text.AnnotatedString


data class ArabicWord(val chars: List<ArabicChar>) {
    constructor(word: String) : this(chars = word.toArabicChars())

    val text = chars.joinToString("") { it.char.toString() }


}