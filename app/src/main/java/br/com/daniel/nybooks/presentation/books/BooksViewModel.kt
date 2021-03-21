package br.com.daniel.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.daniel.nybooks.data.ApiService
import br.com.daniel.nybooks.data.model.Book
import br.com.daniel.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {

       ApiService.service.getBooks().enqueue(object: Callback<BookBodyResponse>{

           override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if (response.isSuccessful) {
                     val books: MutableList<Book> = mutableListOf()

                    response.body()?.let {bookBodyResponse ->
                        for (resultResponse in bookBodyResponse.bookResults) {
                              val book = Book(
                                      title = resultResponse.bookDetailsResponses[0].title,
                                      author = resultResponse.bookDetailsResponses[0].author,
                                      description = resultResponse.bookDetailsResponses[0].description
                              )

                            books.add(book)
                        }

                    }

                    booksLiveData.value = books
                }
           }

           override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

           }

       })
    }

}