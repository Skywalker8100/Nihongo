package com.example.nihongo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nihongo.data.FrequentKanjiData
import com.example.nihongo.data.JapaneseWord
import com.example.nihongo.screens.Navigation
import com.example.nihongo.ui.theme.NihongoTheme
import com.opencsv.CSVReader
import java.io.InputStreamReader

val frequentKanjiList = mutableListOf<FrequentKanjiData>()
val japaneseWordList = mutableListOf<JapaneseWord>()

class MainActivity :
    ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(
            savedInstanceState
        )

        var inputStream = assets.open("kanji_freq.csv")
        var reader = CSVReader(
            InputStreamReader(inputStream)
        )
        var nextLine: Array<String>?

        reader.readNext()

        while (reader.readNext().also { nextLine = it} != null) {
            nextLine?.let {
                val frequentKanjiData = FrequentKanjiData(
                    kanji = it[0],
                    meaning = it[6] + ", " + it[7],
                    kunyomi = it[10] + ", " + it[11],
                    onyomi = it[8] + ", " + it[9],
                    frequency = it[3].toIntOrNull() ?: 10
                )
                frequentKanjiList.add(frequentKanjiData)
            }
        }
        reader.close()

        inputStream = assets.open("Japanese_Data.csv")
        reader = CSVReader(
            InputStreamReader(inputStream)
        )

        reader.readNext()

        while (reader.readNext().also { nextLine = it} != null) {
            nextLine?.let {
                val word = JapaneseWord(
                    category = it[0],
                    kana = it[1],
                    kanji = it[2],
                    english = it[3],
                    romaji = it[3]
                )
                japaneseWordList.add(word)
            }
        }
        reader.close()

        enableEdgeToEdge()
        setContent {
            NihongoTheme {
                Navigation()
            }
        }
    }
}