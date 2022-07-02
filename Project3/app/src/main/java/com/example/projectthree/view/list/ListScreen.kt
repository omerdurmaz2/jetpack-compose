package com.example.projectthree.view.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectthree.model.CryptoListItem

@Composable
fun ListScreen(navController: NavController, viewModel: ListViewModel = hiltViewModel()) {
    Surface(
        color = MaterialTheme.colors.secondary,
        modifier = Modifier.fillMaxSize()

    ) {
        Column {
            Text(
                text = "Crypto App",
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                hint = "Search...", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                viewModel.searchCryptoList(it)
            }
            Spacer(modifier = Modifier.height(10.dp))
            CryptoList(navController = navController)
        }
    }

}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    var hintDisplayed by remember { mutableStateOf(hint != "") }
    Box(modifier = modifier) {
        BasicTextField(
            value = text, onValueChange = {
                text = it
                onSearch(it)
            }, maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 15.dp, vertical = 12.dp)
                .onFocusChanged {
                    hintDisplayed = it.isFocused != true && text.isEmpty()
                }
        )
        if (hintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
fun CryptoList(navController: NavController, viewModel: ListViewModel = hiltViewModel()) {
    val cryptoList by remember { viewModel.cryptoList }
    val errorMessage by remember { viewModel.errorMessage }
    val isLoading by remember { viewModel.isLoading }

    CryptoListView(navController = navController, cryptos = cryptoList)

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
        if (errorMessage.isNotEmpty()) {
            RetryView(errorMessage) {

            }
        }
    }
}

@Composable
fun CryptoListView(navController: NavController, cryptos: List<CryptoListItem>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(cryptos) { crypto ->
            CryptoRow(navController = navController, crypto = crypto)
        }
    }
}

@Composable
fun CryptoRow(navController: NavController, crypto: CryptoListItem) {
    Card(Modifier.fillMaxWidth(), backgroundColor = Color.White) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("detail_screen/${crypto.currency}/${crypto.price}")
            }) {
            Text(
                text = crypto.currency,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(2.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
            Text(
                text = crypto.price,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(2.dp),
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.primaryVariant
            )
        }
    }
}

@Composable
fun RetryView(error: String, onRetry: () -> Unit) {
    Column {
        Text(text = error, color = Color.Red, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { onRetry },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) { Text(text = "Retry") }
    }
}