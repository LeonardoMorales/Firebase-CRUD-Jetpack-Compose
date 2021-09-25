package dev.leonardom.firebasecrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.leonardom.firebasecrud.navigation.Destination
import dev.leonardom.firebasecrud.presentation.book_detail.BookDetailScreen
import dev.leonardom.firebasecrud.presentation.book_detail.BookDetailViewModel
import dev.leonardom.firebasecrud.presentation.book_list.BookListScreen
import dev.leonardom.firebasecrud.presentation.book_list.BookListViewModel
import dev.leonardom.firebasecrud.ui.theme.FirebaseCRUDTheme

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseCRUDTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Destination.BookList.route,
                ){
                    addBookList(navController)

                    addBookDetail()
                }
            }
        }
    }
}

@ExperimentalMaterialApi
fun NavGraphBuilder.addBookList(
    navController: NavController
){
    composable(
        route = Destination.BookList.route
    ){

        val viewModel: BookListViewModel = hiltViewModel()
        val state = viewModel.state.value
        val isRefreshing = viewModel.isRefreshing.collectAsState()

        BookListScreen(
            state = state,
            navigateToBookDetail = {
                navController.navigate(Destination.BookDetail.route)
            },
            isRefreshing = isRefreshing.value,
            refreshData = viewModel::getBookList,
            onItemClick = { bookId ->
                navController.navigate(
                    Destination.BookDetail.route + "?bookId=$bookId"
                )
            }
        )
    }
}

fun NavGraphBuilder.addBookDetail() {
    composable(
        route = Destination.BookDetail.route + "?bookId={bookId}"
    ){

        val viewModel: BookDetailViewModel = hiltViewModel()
        val state = viewModel.state.value

        BookDetailScreen(
            state = state,
            addNewBook = viewModel::addNewBook,
            updateBook = viewModel::updateBook
        )
    }
}