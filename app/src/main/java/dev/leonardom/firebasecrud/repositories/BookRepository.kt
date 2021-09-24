package dev.leonardom.firebasecrud.repositories

import com.google.firebase.firestore.CollectionReference
import dev.leonardom.firebasecrud.model.Book
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository
@Inject
constructor(
    private val bookList: CollectionReference
){

    fun addNewBook(book: Book) {
        try {
            bookList.document(book.id).set(book)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

}










