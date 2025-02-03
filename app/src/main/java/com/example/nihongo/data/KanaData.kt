package com.example.nihongo.data

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nihongo.ui.theme.NihongoTheme

data class Kana(
    val kana: String,
    val romaji: String
)

data class NavigationBarItem (
    val isKanji: Boolean,
    val columns: Int,
    val japaneseTitle: String,
    val title: String,
    val selectedIcon: String,
    val unselectedIcon: String,
    val kanaList: List<Kana>
)

data class FrequentKanjiData(
    val kanji: String,
    val meaning: String,
    val kunyomi: String,
    val onyomi: String,
    val frequency: Int,
)

data class JapaneseWord(
    val category: String,
    val kana: String,
    val kanji: String,
    val english: String,
    val romaji: String
)

val hiraganaList = listOf(
    Kana("あ", "a"), Kana("い", "i"), Kana("う", "u"), Kana("え", "e"), Kana("お", "o"),
    Kana("か", "ka"), Kana("き", "ki"), Kana("く", "ku"), Kana("け", "ke"), Kana("こ", "ko"),
    Kana("さ", "sa"), Kana("し", "shi"), Kana("す", "su"), Kana("せ", "se"), Kana("そ", "so"),
    Kana("た", "ta"), Kana("ち", "chi"), Kana("つ", "tsu"), Kana("て", "te"), Kana("と", "to"),
    Kana("な", "na"), Kana("に", "ni"), Kana("ぬ", "nu"), Kana("ね", "ne"), Kana("の", "no"),
    Kana("は", "ha"), Kana("ひ", "hi"), Kana("ふ", "fu"), Kana("へ", "he"), Kana("ほ", "ho"),
    Kana("ま", "ma"), Kana("み", "mi"), Kana("む", "mu"), Kana("め", "me"), Kana("も", "mo"),
    Kana("や", "ya"), Kana("ゆ", "yu"), Kana("よ", "yo"),
    Kana("ら", "ra"), Kana("り", "ri"), Kana("る", "ru"), Kana("れ", "re"), Kana("ろ", "ro"),
    Kana("わ", "wa"), Kana("を", "wo"), Kana("ん", "n"),
    Kana("が", "ga"), Kana("ぎ", "gi"), Kana("ぐ", "gu"), Kana("げ", "ge"), Kana("ご", "go"),
    Kana("ざ", "za"), Kana("じ", "ji"), Kana("ず", "zu"), Kana("ぜ", "ze"), Kana("ぞ", "zo"),
    Kana("だ", "da"), Kana("ぢ", "ji"), Kana("づ", "zu"), Kana("で", "de"), Kana("ど", "do"),
    Kana("ば", "ba"), Kana("び", "bi"), Kana("ぶ", "bu"), Kana("べ", "be"), Kana("ぼ", "bo"),
    Kana("ぱ", "pa"), Kana("ぴ", "pi"), Kana("ぷ", "pu"), Kana("ぺ", "pe"), Kana("ぽ", "po"),
    Kana("きゃ", "kya"), Kana("きゅ", "kyu"), Kana("きょ", "kyo"),
    Kana("しゃ", "sha"), Kana("しゅ", "shu"), Kana("しょ", "sho"),
    Kana("ちゃ", "cha"), Kana("ちゅ", "chu"), Kana("ちょ", "cho"),
    Kana("にゃ", "nya"), Kana("にゅ", "nyu"), Kana("にょ", "nyo"),
    Kana("ひゃ", "hya"), Kana("ひゅ", "hyu"), Kana("ひょ", "hyo"),
    Kana("みゃ", "mya"), Kana("みゅ", "myu"), Kana("みょ", "myo"),
    Kana("りゃ", "rya"), Kana("りゅ", "ryu"), Kana("りょ", "ryo")
)

val katakanaList = listOf(
    Kana("ア", "a"), Kana("イ", "i"), Kana("ウ", "u"), Kana("エ", "e"), Kana("オ", "o"),
    Kana("カ", "ka"), Kana("キ", "ki"), Kana("ク", "ku"), Kana("ケ", "ke"), Kana("コ", "ko"),
    Kana("サ", "sa"), Kana("シ", "shi"), Kana("ス", "su"), Kana("セ", "se"), Kana("ソ", "so"),
    Kana("タ", "ta"), Kana("チ", "chi"), Kana("ツ", "tsu"), Kana("テ", "te"), Kana("ト", "to"),
    Kana("ナ", "na"), Kana("ニ", "ni"), Kana("ヌ", "nu"), Kana("ネ", "ne"), Kana("ノ", "no"),
    Kana("ハ", "ha"), Kana("ヒ", "hi"), Kana("フ", "fu"), Kana("ヘ", "he"), Kana("ホ", "ho"),
    Kana("マ", "ma"), Kana("ミ", "mi"), Kana("ム", "mu"), Kana("メ", "me"), Kana("モ", "mo"),
    Kana("ヤ", "ya"), Kana("ユ", "yu"), Kana("ヨ", "yo"),
    Kana("ラ", "ra"), Kana("リ", "ri"), Kana("ル", "ru"), Kana("レ", "re"), Kana("ロ", "ro"),
    Kana("ワ", "wa"), Kana("ヲ", "wo"), Kana("ン", "n"),
    Kana("ガ", "ga"), Kana("ギ", "gi"), Kana("グ", "gu"), Kana("ゲ", "ge"), Kana("ゴ", "go"),
    Kana("ザ", "za"), Kana("ジ", "ji"), Kana("ズ", "zu"), Kana("ゼ", "ze"), Kana("ゾ", "zo"),
    Kana("ダ", "da"), Kana("ヂ", "ji"), Kana("ヅ", "zu"), Kana("デ", "de"), Kana("ド", "do"),
    Kana("バ", "ba"), Kana("ビ", "bi"), Kana("ブ", "bu"), Kana("ベ", "be"), Kana("ボ", "bo"),
    Kana("パ", "pa"), Kana("ピ", "pi"), Kana("プ", "pu"), Kana("ペ", "pe"), Kana("ポ", "po"),
    Kana("キャ", "kya"), Kana("キュ", "kyu"), Kana("キョ", "kyo"),
    Kana("シャ", "sha"), Kana("シュ", "shu"), Kana("ショ", "sho"),
    Kana("チャ", "cha"), Kana("チュ", "chu"), Kana("チョ", "cho"),
    Kana("ニャ", "nya"), Kana("ニュ", "nyu"), Kana("ニョ", "nyo"),
    Kana("ヒャ", "hya"), Kana("ヒュ", "hyu"), Kana("ヒョ", "hyo"),
    Kana("ミャ", "mya"), Kana("ミュ", "myu"), Kana("ミョ", "myo"),
    Kana("リャ", "rya"), Kana("リュ", "ryu"), Kana("リョ", "ryo")
)

val basicHiraganaList = listOf(
    Kana("あ", "a"), Kana("い", "i"), Kana("う", "u"), Kana("え", "e"), Kana("お", "o"),
    Kana("か", "ka"), Kana("き", "ki"), Kana("く", "ku"), Kana("け", "ke"), Kana("こ", "ko"),
    Kana("さ", "sa"), Kana("し", "shi"), Kana("す", "su"), Kana("せ", "se"), Kana("そ", "so"),
    Kana("た", "ta"), Kana("ち", "chi"), Kana("つ", "tsu"), Kana("て", "te"), Kana("と", "to"),
    Kana("な", "na"), Kana("に", "ni"), Kana("ぬ", "nu"), Kana("ね", "ne"), Kana("の", "no"),
    Kana("は", "ha"), Kana("ひ", "hi"), Kana("ふ", "fu"), Kana("へ", "he"), Kana("ほ", "ho"),
    Kana("ま", "ma"), Kana("み", "mi"), Kana("む", "mu"), Kana("め", "me"), Kana("も", "mo"),
    Kana("や", "ya"), Kana("", ""), Kana("ゆ", "yu"), Kana("", ""), Kana("よ", "yo"),
    Kana("ら", "ra"), Kana("り", "ri"), Kana("る", "ru"), Kana("れ", "re"), Kana("ろ", "ro"),
    Kana("わ", "wa"), Kana("", ""), Kana("を", "wo"), Kana("", ""), Kana("ん", "n")
)

val comboHiraganaList = listOf(
    Kana("きゃ", "kya"), Kana("きゅ", "kyu"), Kana("きょ", "kyo"),
    Kana("しゃ", "sha"), Kana("しゅ", "shu"), Kana("しょ", "sho"),
    Kana("ちゃ", "cha"), Kana("ちゅ", "chu"), Kana("ちょ", "cho"),
    Kana("にゃ", "nya"), Kana("にゅ", "nyu"), Kana("にょ", "nyo"),
    Kana("ひゃ", "hya"), Kana("ひゅ", "hyu"), Kana("ひょ", "hyo"),
    Kana("みゃ", "mya"), Kana("みゅ", "myu"), Kana("みょ", "myo"),
    Kana("りゃ", "rya"), Kana("りゅ", "ryu"), Kana("りょ", "ryo")
)

val basicKatakanaList = listOf(
    Kana("ア", "a"), Kana("イ", "i"), Kana("ウ", "u"), Kana("エ", "e"), Kana("オ", "o"),
    Kana("カ", "ka"), Kana("キ", "ki"), Kana("ク", "ku"), Kana("ケ", "ke"), Kana("コ", "ko"),
    Kana("サ", "sa"), Kana("シ", "shi"), Kana("ス", "su"), Kana("セ", "se"), Kana("ソ", "so"),
    Kana("タ", "ta"), Kana("チ", "chi"), Kana("ツ", "tsu"), Kana("テ", "te"), Kana("ト", "to"),
    Kana("ナ", "na"), Kana("ニ", "ni"), Kana("ヌ", "nu"), Kana("ネ", "ne"), Kana("ノ", "no"),
    Kana("ハ", "ha"), Kana("ヒ", "hi"), Kana("フ", "fu"), Kana("ヘ", "he"), Kana("ホ", "ho"),
    Kana("マ", "ma"), Kana("ミ", "mi"), Kana("ム", "mu"), Kana("メ", "me"), Kana("モ", "mo"),
    Kana("ヤ", "ya"), Kana("", ""), Kana("ユ", "yu"), Kana("", ""), Kana("ヨ", "yo"),
    Kana("ラ", "ra"), Kana("リ", "ri"), Kana("ル", "ru"), Kana("レ", "re"), Kana("ロ", "ro"),
    Kana("ワ", "wa"), Kana("", ""), Kana("ヲ", "wo"), Kana("", ""), Kana("ン", "n")
)



val comboKatakanaList = listOf(
    Kana("キャ", "kya"), Kana("キュ", "kyu"), Kana("キョ", "kyo"),
    Kana("シャ", "sha"), Kana("シュ", "shu"), Kana("ショ", "sho"),
    Kana("チャ", "cha"), Kana("チュ", "chu"), Kana("チョ", "cho"),
    Kana("ニャ", "nya"), Kana("ニュ", "nyu"), Kana("ニョ", "nyo"),
    Kana("ヒャ", "hya"), Kana("ヒュ", "hyu"), Kana("ヒョ", "hyo"),
    Kana("ミャ", "mya"), Kana("ミュ", "myu"), Kana("ミョ", "myo"),
    Kana("リャ", "rya"), Kana("リュ", "ryu"), Kana("リョ", "ryo")
)

@Composable
fun WordBox(word: JapaneseWord) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                7.dp
            )
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(
                    20
                )
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = word.kanji,
            fontSize = 34.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(
                    0.3f
                )
                .padding(
                    start = 35.dp
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    8.dp
                )
        ) {
            Text(
                text = "Meaning: ${word.english}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Text(
                text = "Kana: ${word.kana}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Text(
                text = "Romaji: ${word.romaji}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}

@Composable
fun KanjiBox(kanji: FrequentKanjiData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                7.dp
            )
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(
                    20
                )
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = kanji.kanji,
            fontSize = 34.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(
                    0.3f
                )
                .padding(
                    start = 35.dp
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    8.dp
                )
        ) {
            Text(
                text = "Meaning: ${kanji.meaning}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Text(
                text = "Kunyomi: ${kanji.kunyomi}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Text(
                text = "Onyomi: ${kanji.onyomi}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}

@Composable
fun KanaBox(kana: Kana) {
    OutlinedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier
            .size(
                92.dp
            )
            .padding(
                7.dp
            )
            .clip(
                RoundedCornerShape(
                    16.dp
                )
            )
            .clickable(
                onClick = {}
            ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = kana.kana,
                fontSize = 28.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = kana.romaji,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
fun KanaBoxPreview() {
    NihongoTheme {
        KanaBox(Kana("あ", "a"))
    }
}

