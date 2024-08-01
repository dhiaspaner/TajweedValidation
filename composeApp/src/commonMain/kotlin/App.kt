import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import arabic.toArabicText
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import rules.Ghonnah
import rules.Idhehar
import rules.Idhgham
import rules.Ikhfa
import rules.Iklab
import rules.Kalkala
import tajweedvalidation.composeapp.generated.resources.Res
import tajweedvalidation.composeapp.generated.resources.border


@Composable
@Preview
fun App() {
    MaterialTheme {
        val textList = remember {
            listOf(
                "وَمَنْ أَعْرَضَ عَن ذِكْرِي",
                "إِنَّآ أَعْطَيْنَـٰكَ ٱلْكَوْثَرَ",
                "وَجَنَّاتٍ أَلْفَافاً",
                "وَمِـنْهُمْ دُونَ ذَلِكَ",
                "وَهُمْ يَنْهَوْنَ عَنْهُ وَيَنْأَوْنَ عَنْهُ",
                "وَلِكُلِّ قَوْمٍ هَادٍ",
                "إنَّ اللّهَ عَزِيزٌ حَكِيمٌٍ",
                "وَكَانُواْ يَنْحِتُونَ مِنَ الْجِبَالِ بُيُوتاً آمِنِينَ",
                "وَهُوَ بِكُلِّ شَيْءٍ عَلِيمٌ",
                "وَلَا طَعَامٌ إِلَّا مِنْ غِسْلِينٍ",
                "إِنَّ اللّهَ كَانَ عَفُوّاً غَفُوراً",
                "وَإِنَّ مِنْهَا لَمَا يَهْبِطُ مِنْ خَشْيَةِ اللّهِ",
                "فَمَن يَعْمَلْ مِثْقَالَ ذَرَّةٍ خَيْراً يَرَهُ",
                "وَيُسْقَى مِن مَّـاء صَدِيدٍ",
                "اقْتَرَبَتِ السَّاعَةُ وَانشَقَّ الْقَمَرُ",
                "وَلَئِنْ أَذَقْنَا الإِنْسَانَ مِنَّا رَحْمَةً ثُـمَّ نَزَعْنَاهَا مِنْهُ إِنَّهُ لَيَؤُوسٌ كَـفُورٌ",
                "ذَلِكَ مِنْ أَنبَـاء الْغَيْبِ نُوحِيهِ إِلَيكَ",
                "والعَص",

                )
        }

        val tajweedRules = remember {
            listOf(
                Idhehar(color = Color.Green),
                Ghonnah(color = Color.Red),
                Idhgham(color = Color.Gray),
                Kalkala(Color.Blue),
                Ikhfa(Color.Yellow),
                Iklab(Color.Cyan),
            )
        }

        val annotatingStrings = remember {
            textList.map { it.toArabicText(tajweedRules = tajweedRules).generateAnnotatingString() }
        }

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                ) {
                    annotatingStrings.forEach { annotatingString ->
                        Text(annotatingString)
                    }
                }
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(Res.drawable.border),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

