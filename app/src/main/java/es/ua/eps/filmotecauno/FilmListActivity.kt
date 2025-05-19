package es.ua.eps.filmotecauno

import android.content.Intent
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class FilmListActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_list)

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)

        listView = findViewById(R.id.film_list)
        adapter = FilmAdapter(this, FilmDataSource.films)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, FilmDataActivity::class.java)
            intent.putExtra("filmIndex", position)
            startActivity(intent)
        }

        // MODO MULTISELECCIÓN Y ACTION MODE
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
        listView.setMultiChoiceModeListener(object : AbsListView.MultiChoiceModeListener {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                menuInflater.inflate(R.menu.film_list_contextual_menu, menu)
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?) = false

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return when (item?.itemId) {
                    R.id.miBorrar -> {
                        borrarItemsSeleccionados()
                        mode?.finish()
                        true
                    }
                    else -> false
                }
            }

            override fun onDestroyActionMode(mode: ActionMode?) {}

            override fun onItemCheckedStateChanged(
                mode: ActionMode?,
                position: Int,
                id: Long,
                checked: Boolean
            ) {}
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.film_list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.miNuevaPelicula -> {
                nuevaPelicula()
                true
            }
            R.id.miAcercaDe -> {
                abrirAcercaDe()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun nuevaPelicula() {
        val f = Film()
        f.title = "<Nueva película>"
        f.director = "Director desconocido"
        f.imageResId = R.mipmap.ic_launcher
        FilmDataSource.films.add(f)
        adapter.notifyDataSetChanged()
    }

    private fun abrirAcercaDe() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun borrarItemsSeleccionados() {
        val checkedPositions = listView.checkedItemPositions
        val toDelete = mutableListOf<Film>()
        for (i in 0 until checkedPositions.size()) {
            if (checkedPositions.valueAt(i)) {
                toDelete.add(FilmDataSource.films[checkedPositions.keyAt(i)])
            }
        }
        FilmDataSource.films.removeAll(toDelete)
        adapter.notifyDataSetChanged()
    }
}
