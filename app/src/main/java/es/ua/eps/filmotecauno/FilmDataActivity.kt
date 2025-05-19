package es.ua.eps.filmotecauno

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem

const val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE"

class FilmDataActivity<TextView> : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_data)

        // Configurar el Toolbar como app bar
        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detalles de la película"

        val imagePoster = findViewById<ImageView>(R.id.image_poster)
        val textTitle = findViewById<android.widget.TextView>(R.id.text_title)
        val textDirector = findViewById<android.widget.TextView>(R.id.text_director)
        val textYear = findViewById<android.widget.TextView>(R.id.text_year)
        val textGenre = findViewById<android.widget.TextView>(R.id.text_genre)
        val textFormat = findViewById<android.widget.TextView>(R.id.text_format)
        val textNotes = findViewById<android.widget.TextView>(R.id.text_notes)
        val btnImdb = findViewById<Button>(R.id.btn_imdb)
        val btnEditar = findViewById<Button>(R.id.btn_editar)
        val btnVolver = findViewById<Button>(R.id.btn_volver)


        val index = intent.getIntExtra("filmIndex", -1)
        val film = FilmDataSource.films.getOrNull(index)

        film?.let {
            textTitle.text = it.title
            textDirector.text = "Director: ${it.director}"
            textYear.text = "Año: ${it.year}"
            textGenre.text = "Género: ${getGenreName(it.genre)}"
            textFormat.text = "Formato: ${getFormatName(it.format)}"
            textNotes.text = "Notas: ${it.comments}"
            imagePoster.setImageResource(it.imageResId)
        }
        // Simulación de datos (en el futuro pueden venir de una base de datos)
        //textTitle.text = "Regreso al futuro"
        //textDirector.text = "Director: Robert Zemeckis"
        //textYear.text = "Año: 1985"
        //textGenre.text = "Género: Bluray, Sci-Fi"
        //textFormat.text = "Formato: Digital"
        //textNotes.text = "Notas: Clásico del cine de ciencia ficción"
        //imagePoster.setImageResource(R.drawable.ic_launcher_foreground)


        // Botón para abrir IMDB
        btnImdb.setOnClickListener {
            val imdbIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/title/tt0088763/"))
            startActivity(imdbIntent)
        }

        // Volver a la pantalla principal
        btnVolver.setOnClickListener {
            val intent = Intent(this, FilmListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        // Editar la película
        btnEditar.setOnClickListener {
            val intent = Intent(this, FilmEditActivity::class.java)
            startActivity(intent)
        }
    }

    // ✅ ESTE MÉTODO va FUERA del onCreate
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, FilmListActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun getGenreName(index: Int): String {
        return when (index) {
            Film.GENRE_ACTION -> "Acción"
            Film.GENRE_COMEDY -> "Comedia"
            Film.GENRE_DRAMA -> "Drama"
            Film.GENRE_SCIFI -> "Sci-Fi"
            Film.GENRE_HORROR -> "Terror"
            else -> "Desconocido"
        }
    }

    fun getFormatName(index: Int): String {
        return when (index) {
            Film.FORMAT_DVD -> "DVD"
            Film.FORMAT_BLURAY -> "Blu-ray"
            Film.FORMAT_DIGITAL -> "Digital"
            else -> "Desconocido"
        }
    }




}