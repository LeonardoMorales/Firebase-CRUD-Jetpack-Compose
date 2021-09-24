package dev.leonardom.firebasecrud.presentation.book_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leonardom.firebasecrud.model.Book
import dev.leonardom.firebasecrud.repositories.BookRepository
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel
@Inject
constructor(
    private val bookRepository: BookRepository
): ViewModel() {

    private val _state: MutableState<BookDetailState> = mutableStateOf(BookDetailState())
    val state: State<BookDetailState>
        get() = _state

    fun addNewBook(title: String, author: String) {
        val book = Book(
            id = UUID.randomUUID().toString(),
            coverURL = "https://media.istockphoto.com/photos/blank-book-cover-white-picture-id178447904",
            title = title,
            author = author,
            rating = 0.0f,
            downloads = 0
        )

        bookRepository.addNewBook(book)
    }

}












