package dev.leonardom.firebasecrud.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument>
){
    object BookList : Destination("bookList", emptyList())
    object BookDetail: Destination(
        route = "bookDetail",
        arguments = listOf(
            navArgument("bookId"){
                nullable = true
            }
        )
    )
}
