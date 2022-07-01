package com.jetpack.projectone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GuessScreen(navController: NavController) {
    val guess = remember { mutableStateOf("") }
    val counter = remember { mutableStateOf(5) }
    val randomNumber = remember { mutableStateOf(0) }
    val maxLength = 3

    LaunchedEffect(key1 = true) {
        randomNumber.value = (0..100).random()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Kalan Hak ${counter.value}",
            color = Color.Red,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = guess.value,
            onValueChange = {
                if (it.length <= maxLength) guess.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Button(onClick = {
            println(randomNumber)
            if (guess.value == "$randomNumber") {
                navController.navigate("result_screen/true") {
                    popUpTo("guess_screen") {
                        inclusive = true
                    }
                }
            } else {
                counter.value = counter.value - 1
                if (counter.value == 0) {
                    navController.navigate("result_screen/false") {
                        popUpTo("guess_screen") {
                            inclusive = true
                        }
                    }
                }
            }
        }) {
            Text(text = "Tahmin Et")
        }
    }


}

