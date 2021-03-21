package br.com.daniel.nybooks.presentation.books

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.daniel.nybooks.R
import br.com.daniel.nybooks.presentation.base.BaseActivity
import br.com.daniel.nybooks.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BooksActivity : BaseActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        setupToolbar(toolbarMain, R.string.books_title)

        val viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

         viewModel.booksLiveData.observe(this, Observer {
             it?.let { books ->
                 with(recyclerBooks) {
                     layoutManager =
                         LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                     setHasFixedSize(true)
                     adapter = BooksAdapter(books) { book ->
                      val intent = BookDetailsActivity.getStartIntent(this@BooksActivity, book.title, book.description)
                      this@BooksActivity.startActivity(intent)
                     }
                 }

         }
         })

         viewModel.viewFlipperLiveData.observe(this, Observer {
             it?.let { viewFlipper ->
                 viewFlipperBooks.displayedChild = viewFlipper.first
                 viewFlipper.second?.let { errorMessageResId  ->
                     textViewError.text = getString(errorMessageResId)
                 }
             }
         })

        viewModel.getBooks()
    }

}