package com.jetpack.projectone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ResultScreen(navController: NavController, result: Boolean?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(id = if (result == true) R.string.happy_face else R.string.sad_face),
            fontSize = 100.sp
        )
        Text(
            text = stringResource(id = if (result == true) R.string.happy_message else R.string.sad_message),
            fontSize = 50.sp,
            textAlign = TextAlign.Center
        )
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Tekrar Oyna")
        }
    }
}