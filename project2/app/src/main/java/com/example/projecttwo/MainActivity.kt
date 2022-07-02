package com.example.projecttwo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projecttwo.ui.theme.ProjectTwoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTwoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PageDynamicListing()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjectTwoTheme {
        PageDynamicListing()
    }
}

@Composable
fun PageDynamicListing() {
    val countryList = remember {
        mutableListOf(
            "Turkiye",
            "Almanya",
            " Rusya",
            "Amerika",
            "Danimarka",
            "Ingiltere"
        )
    }

    LazyColumn {
        items(count = countryList.size, itemContent = {
            val country = countryList[it]
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.clickable { }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Text(text = country, modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        })
    }
}

@Composable
fun PageStaticListing() {
    LazyRow {
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .size(160.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        Log.e("list", "Clicked")
                    }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                            contentDescription = ""
                        )
                        Text(text = "Gunes", modifier = Modifier.padding(all = 5.dp))
                    }
                }

            }
        }

        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .size(160.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        Log.e("list", "Clicked")
                    }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                            contentDescription = ""
                        )
                        Text(text = "Ay", modifier = Modifier.padding(all = 5.dp))
                    }
                }

            }
        }

        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .size(160.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        Log.e("list", "Clicked")
                    }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                            contentDescription = ""
                        )
                        Text(text = "Jupiter", modifier = Modifier.padding(all = 5.dp))
                    }
                }

            }
        }
    }
}