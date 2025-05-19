package es.ua.eps.filmotecauno

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast


class FilmEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_edit)

        val imagePoster = findViewById<ImageView>(R.id.image_poster)
        val btnCapturarFoto = findViewById<Button>(R.id.btn_capturar_foto)
        val btnSeleccionarImagen = findViewById<Button>(R.id.btn_seleccionar_imagen)
        val editTitulo = findViewById<EditText>(R.id.edit_titulo)
        val editDirector = findViewById<EditText>(R.id.edit_director)
        val editAno = findViewById<EditText>(R.id.edit_ano)
        val editImdb = findViewById<EditText>(R.id.edit_imdb)
        val spinnerGenero = findViewById<Spinner>(R.id.spinner_genero)
        val spinnerFormato = findViewById<Spinner>(R.id.spinner_formato)
        val editNotas = findViewById<EditText>(R.id.edit_notas)
        val btnGuardar = findViewById<Button>(R.id.btn_guardar)
        val btnCancelar = findViewById<Button>(R.id.btn_cancelar)

        btnCancelar.setOnClickListener {
            finish()
        }

        btnGuardar.setOnClickListener {
            Toast.makeText(this, "Película guardada", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}