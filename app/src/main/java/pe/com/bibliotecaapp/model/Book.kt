package pe.com.bibliotecaapp.model

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val year: Int,
    val imageResourceId: Int,
    val genres: List<String>,
    val description: String
)