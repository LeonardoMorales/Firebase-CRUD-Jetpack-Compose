package dev.leonardom.firebasecrud.presentation.book_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.leonardom.firebasecrud.ui.theme.Red100

@Composable
fun BookDetailScreen() {

    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = title,
                onValueChange = { title = it},
                label = {
                    Text(text = "Title")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = author,
                onValueChange = { author = it},
                label = {
                    Text(text = "Author")
                }
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            onClick = {
                // TODO("ADD NEW BOOK")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Red100
            )
        ) {
            Text(
                text = "Add New Book",
                color = Color.White
            )
        }
    }
}