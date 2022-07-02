package com.example.projectthree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.projectthree.ui.theme.ProjectThreeTheme
import com.example.projectthree.view.detail.DetailScreen
import com.example.projectthree.view.list.ListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectThreeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "list_screen", builder = {
                    composable("list_screen") {
                        ListScreen(navController = navController)
                    }
                    composable(
                        "detail_screen/{cryptoId}/{cryptoPrice}", arguments = listOf(
                            navArgument(name = "cryptoId") {
                                type = NavType.StringType
                            },
                            navArgument(name = "cryptoPrice") {
                                type = NavType.StringType
                            },
                        )
                    ) {
                        val cryptoId = remember { it.arguments?.getString("cryptoId") }
                        val cryptoPrice = remember { it.arguments?.getString("cryptoPrice") }
                        DetailScreen(
                            navController = navController,
                            cryptoId = cryptoId ?: "",
                            cryptoPrice = cryptoPrice ?: ""
                        )
                    }
                })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjectThreeTheme {
    }
}