import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import arabic.toArabicText
import org.jetbrains.compose.ui.tooling.preview.Preview
import rules.Ghonnah
import rules.Idhehar
import rules.Idhgham
import rules.Ikhfa
import rules.Iklab
import rules.Kalkala
import rules.TafkhimRaWithSukunAndSukunBeforeAndFateh
import rules.TajweedRule


@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        val textList =
            listOf(
//                "وَمَنْ أَعْرَضَ عَن ذِكْرِي",
//                "إِنَّآ أَعْطَيْنَـٰكَ ٱلْكَوْثَرَ",
//                "وَجَنَّاتٍ أَلْفَافاً",
//                "وَمِـنْهُمْ دُونَ ذَلِكَ",
//                "وَهُمْ يَنْهَوْنَ عَنْهُ وَيَنْأَوْنَ عَنْهُ",
//                "وَلِكُلِّ قَوْمٍ هَادٍ",
//                "إنَّ اللّهَ عَزِيزٌ حَكِيمٌٍ",
//                "وَكَانُواْ يَنْحِتُونَ مِنَ الْجِبَالِ بُيُوتاً آمِنِينَ",
//                "وَهُوَ بِكُلِّ شَيْءٍ عَلِيمٌ",
//                "وَلَا طَعَامٌ إِلَّا مِنْ غِسْلِينٍ",
//                "إِنَّ اللّهَ كَانَ عَفُوّاً غَفُوراً",
//                "وَإِنَّ مِنْهَا لَمَا يَهْبِطُ مِنْ خَشْيَةِ اللّهِ",
//                "فَمَن يَعْمَلْ مِثْقَالَ ذَرَّةٍ خَيْراً يَرَهُ",
//                "وَيُسْقَى مِن مَّـاء صَدِيدٍ",
//                "اقْتَرَبَتِ السَّاعَةُ وَانشَقَّ الْقَمَرُ",
                "وَلَئِنْ أَذَقْنَا الإِنْسَانَ مِنَّا رَحْمَةً ثُـمَّ نَزَعْنَاهَا مِنْهُ إِنَّهُ لَيَؤُوسٌ كَـفُورٌ",
//                "ذَلِكَ مِنْ أَنبَـاء الْغَيْبِ نُوحِيهِ إِلَيكَ",
//                "والعَصِرْ",

            )


        val quranText = "إِنَّا أَعْطَيْنَاكَ ٱلْكَوْثَرَ"
        val tajweedRules = remember {
            listOf(
                Idhehar(color = Color.Green),
                Ghonnah(color = Color.Red),
                Idhgham(color = Color.Gray),
                Kalkala(Color.Blue),
                Ikhfa(Color.Yellow),
                Iklab(Color.Cyan),
                TafkhimRaWithSukunAndSukunBeforeAndFateh(Color.Magenta)
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
            textList.forEach { text ->
                println()
                Text(
                    text.toArabicText(tajweedRules = tajweedRules).generateAnnotatingString().also {
                        println("Annotating string: ${it.text}")
                    }
                )
            }
        }
    }
}

