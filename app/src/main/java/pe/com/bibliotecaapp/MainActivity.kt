package pe.com.bibliotecaapp

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pe.com.bibliotecaapp.ViewModel.BookService

import pe.com.bibliotecaapp.adapter.BookAdapter
import pe.com.bibliotecaapp.model.Book
import pe.com.bibliotecaapp.databinding.ActivityMainBinding
import pe.com.bibliotecaapp.detail.BookDetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadBooks()


    }


    private fun setupRecyclerView() {
        bookAdapter = BookAdapter { book ->
            val intent = Intent(this, BookDetailActivity::class.java)
            intent.putExtra("BOOK_ID", book.id)
            startActivity(intent)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = bookAdapter
        }
    }

    private fun loadBooks() {
        val books = BookService.getBooks()
        bookAdapter.submitList(books)
    }
}