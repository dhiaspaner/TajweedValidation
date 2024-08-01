package arabic

import com.benasher44.uuid.Uuid


data class ArabicChar(
    val char: Char,
    val vowels: List<Vowel> = emptyList()
) {


}
