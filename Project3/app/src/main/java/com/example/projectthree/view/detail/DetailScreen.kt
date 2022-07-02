package com.example.projectthree.view.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, cryptoId: String, cryptoPrice: String) {
    Text(text = "Detail Screen")
}