package dev.leonardom.firebasecrud.presentation.book_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leonardom.firebasecrud.repositories.BookRepository
import dev.leonardom.firebasecrud.repositories.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookListViewModel
@Inject
constructor(
    private val bookRepository: BookRepository
): ViewModel() {

    private val _state: MutableState<BookListState> = mutableStateOf(BookListState())
    val state: State<BookListState> = _state

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    init {
        getBookList()
    }

    fun getBookList() {
        bookRepository.getBookList().onEach { result ->
            when(result) {
                is Result.Error -> {
                    _state.value = BookListState(error = result.message ?: "Error Inesperado")
                }
                is Result.Loading -> {
                    _state.value = BookListState(isLoading = true)
                }
                is Result.Success -> {
                    _state.value = BookListState(books = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

    fun deleteBook(bookId: String) {
        bookRepository.deleteBook(bookId)
    }

}




























