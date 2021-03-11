package br.com.daniel.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.daniel.nybooks.R
import br.com.daniel.nybooks.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(
      private val books: List<Book>
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder {
         val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
         return BooksViewHolder(itemView)
    }

    override fun getItemCount() = books.count()

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
      viewHolder.bindView(books[position])
    }

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.textTitle
        private val author = itemView.textAuthor

        fun bindView(book: Book) {
           title.text = book.title
           author.text = book.author
        }
    }
}