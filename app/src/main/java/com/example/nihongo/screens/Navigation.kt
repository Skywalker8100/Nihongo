package com.example.nihongo.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "KanaScreen"
    ) {
        composable("HomeScreen") {
            HomeScreen(navController)
        }
        composable("KanaScreen") {
            KanaScreen(navController)
        }
        composable("DictionaryScreen") {
            DictionaryScreen(navController)
        }
    }
}