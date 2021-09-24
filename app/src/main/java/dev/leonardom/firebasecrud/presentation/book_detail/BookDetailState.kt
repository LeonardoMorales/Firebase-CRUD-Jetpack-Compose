package dev.leonardom.firebasecrud.presentation.book_detail

import dev.leonardom.firebasecrud.model.Book

data class BookDetailState(
    val isLoading: Boolean = false,
    val book: Book? = null,
    val error: String = ""
)
