package pe.com.bibliotecaapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pe.com.bibliotecaapp.ViewModel.BookService
import pe.com.bibliotecaapp.databinding.ActivityBookDetailBinding


class BookDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookId = intent.getIntExtra("BOOK_ID", -1)
        if (bookId != -1) {
            val book = BookService.getBookById(bookId)
            book?.let {
                binding.apply {
                    imageView.setImageResource(it.imageResourceId)
                    titleTextView.text = it.title
                    authorTextView.text = it.author
                    yearTextView.text = it.year.toString()
                    genresTextView.text = it.genres.joinToString(", ")
                    descriptionTextView.text = it.description
                }
            }
        }
    }
}