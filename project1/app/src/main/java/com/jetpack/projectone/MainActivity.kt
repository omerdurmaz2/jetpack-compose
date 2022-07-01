package com.jetpack.projectone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jetpack.projectone.ui.theme.ProjectOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectOneTheme {
                Surface {
                    ScreenNavigation()
                }
            }
        }
    }
}

@Composable
fun HomePage(navController: NavController) {


    Scaffold(floatingActionButton = {
        ExtendedFloatingActionButton(
            backgroundColor = Color(0xFF923939),
            text = { Text(text = "Basla", color = Color.White) },
            icon = {
                Image(
                    painter = painterResource(R.drawable.ic_baseline_play_arrow_24),
                    contentDescription = ""
                )
            },
            onClick = { navController.navigate("guess_screen") })
    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Sayi Tahmin Uygulamasi")
            Image(
                painter = painterResource(R.drawable.ic_baseline_casino_24),
                contentDescription = "",
            )
        }
    }
}

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_page") {
        composable("home_page") {
            HomePage(navController)
        }
        composable("guess_screen") {
            GuessScreen(navController)
        }
        composable("result_screen/{result}", arguments = listOf(
            navArgument("result") { type = NavType.BoolType }
        )) {
            val result = it.arguments?.getBoolean("result")
            ResultScreen(navController, result)
        }
    }
}
