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
import dev.leonardom.firebasecrud.presentation.book_list.BookListState
import dev.leonardom.firebasecrud.presentation.book_list.BookListViewModel
import dev.leonardom.firebasecrud.ui.theme.FirebaseCRUDTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

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
        BookListScreen(
            navigateToBookDetail = {
                navController.navigate(Destination.BookDetail.route)
            },
            isRefreshing = false,
            refreshData = {}
        )
    }
}

fun NavGraphBuilder.addBookDetail() {
    composable(
        route = Destination.BookDetail.route
    ){

        val viewModel: BookDetailViewModel = hiltViewModel()
        val state = viewModel.state.value

        BookDetailScreen(
            state = state,
            addNewBook = viewModel::addNewBook
        )
    }
}