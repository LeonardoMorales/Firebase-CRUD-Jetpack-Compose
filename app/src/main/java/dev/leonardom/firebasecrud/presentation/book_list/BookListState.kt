package dev.leonardom.firebasecrud.presentation.book_list

import dev.leonardom.firebasecrud.model.Book

data class BookListState(
    val isLoading: Boolean = false,
    val books: List<Book> = emptyList(),
    val error: String = ""
)
