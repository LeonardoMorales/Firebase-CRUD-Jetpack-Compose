package dev.leonardom.firebasecrud.presentation.book_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.leonardom.firebasecrud.presentation.book_list.components.BookList
import dev.leonardom.firebasecrud.ui.theme.Red100

@ExperimentalMaterialApi
@Composable
fun BookListScreen(
    state: BookListState,
    navigateToBookDetail: () -> Unit,
    isRefreshing: Boolean,
    refreshData: () -> Unit,
    onItemClick: (String) -> Unit,
    deleteBook: (String) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToBookDetail,
                backgroundColor = Red100,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
            }
        }
    ) {
        BookList(
            state = state,
            isRefreshing = isRefreshing,
            refreshData = refreshData,
            onItemClick = onItemClick,
            deleteBook = deleteBook
        )
    }
}