package arabic

import rules.TajweedRule


fun String.toArabicChars(): List<ArabicChar> {

    val chars = mutableListOf<ArabicChar>()
    val vowels = mutableListOf<Vowel>()
    var currentCharIndex = -1

    forEachIndexed() { index, c ->
        // check for hamza at the beginning of the word
        if (index == 0 && c in listOf( 'آ','ا')){
            chars.add(ArabicChar(char = c,vowels = emptyList()))
            return@forEachIndexed
        }

        if (c in ArabicText.chars ) {
            if (currentCharIndex != -1) {
                chars.add(ArabicChar(char = get(currentCharIndex), vowels = vowels.toList()))
                vowels.clear()
            }
            currentCharIndex = index
        } else {
            vowels.add(getVowel(c) ?: throw IllegalArgumentException("Invalid vowel $c"))
        }
    }

    if (currentCharIndex != -1) {
        chars.add(ArabicChar(char = get(currentCharIndex), vowels = vowels.toList()))
    }
    return chars
}

fun String.toArabicText(tajweedRules: List<TajweedRule> = emptyList()) = ArabicText(words = split(" ").map { ArabicWord(it) },tajweedRules)

fun getVowel(char: Char): Vowel? {
    return when (char) {
        'َ' -> Vowel.FATHA
        'ِ' -> Vowel.KASRA
        'ُ' -> Vowel.DAMMA
        'ْ' -> Vowel.SUKUN
        'ّ' -> Vowel.SHADDA
        'ً' -> Vowel.TANWEENFATH
        'ٍ' -> Vowel.TANWEENKASR
        'ٌ' -> Vowel.TANWEENDHAM
        'ـ' -> Vowel.Tamtit
        'ٰ','ا','ٱ' -> Vowel.MADDAH
        'آ' -> Vowel.MADDAHTAWIL
        else -> null
    }
}

fun Vowel.toSymbol(): String {
    return when (this) {
        Vowel.FATHA -> "َ"
        Vowel.KASRA -> "ِ"
        Vowel.DAMMA -> "ُ"
        Vowel.SUKUN -> "ْ"
        Vowel.SHADDA -> "ّ"
        Vowel.MADDAH -> "ا"
        Vowel.TANWEENFATH -> "ً"
        Vowel.TANWEENKASR -> "ٍ"
        Vowel.TANWEENDHAM -> "ٌ"
        Vowel.Tamtit -> "ـ"
        Vowel.MADDAHTAWIL -> "آ"
    }
}
