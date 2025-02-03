package com.example.nihongo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nihongo.data.KanaBox
import com.example.nihongo.data.KanjiBox
import com.example.nihongo.data.NavigationBarItem
import com.example.nihongo.data.basicHiraganaList
import com.example.nihongo.data.basicKatakanaList
import com.example.nihongo.frequentKanjiList

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun KanaScreen(navController: NavHostController) {

    val sortedFrequentKanjiList = frequentKanjiList.sortedBy { it.frequency }

    val items = listOf(
        NavigationBarItem(
            isKanji = false,
            columns = 5,
            japaneseTitle = "ひらがな",
            title = "Hiragana",
            selectedIcon = "あ",
            unselectedIcon = "あ",
            kanaList = basicHiraganaList
        ),
        NavigationBarItem(
            isKanji = false,
            columns = 5,
            japaneseTitle = "カタカナ",
            title = "Katakana",
            selectedIcon = "ア",
            unselectedIcon = "ア",
            kanaList = basicKatakanaList
        ),
        NavigationBarItem(
            isKanji = true,
            columns = 1,
            japaneseTitle = "漢字",
            title = "Kanji",
            selectedIcon = "漢",
            unselectedIcon = "漢",
            kanaList = basicKatakanaList
        )
    )

    var kanaList by rememberSaveable {
        mutableStateOf(basicHiraganaList)
    }

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    var columns by rememberSaveable {
        mutableIntStateOf(5)
    }

    var isKanji by rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(selectedItemIndex) {
        kanaList = items[selectedItemIndex].kanaList
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier.clip(
                    RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            columns = item.columns
                            isKanji = item.isKanji
                        },
                        label = {
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = if (selectedItemIndex == index) MaterialTheme.colorScheme.primary else Color.Gray
                                )
                            )
                        },
                        icon = {
                            Text(
                                text = item.selectedIcon,
                                style = MaterialTheme.typography.headlineMedium,
                                color = if (selectedItemIndex == index) MaterialTheme.colorScheme.primary else Color.Gray
                            )
                        }
                    )
                }
            }
        },
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = items[selectedItemIndex].japaneseTitle,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 32.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 38.dp),
                        textAlign = TextAlign.Center

                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate("KanaScreen")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Back",
                            modifier = Modifier.size(34.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) {
            padding ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 90.dp, bottom = 90.dp)
        ) {
            if(isKanji) {
                items(
                    sortedFrequentKanjiList
                ) {
                    KanjiBox(it)
                }
            } else {
                items(
                    kanaList
                ) {
                    KanaBox(it)
                }
            }
        }
    }
}