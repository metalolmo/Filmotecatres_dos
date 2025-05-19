package es.ua.eps.filmotecauno

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FilmAdapter(context: Context, films: List<Film>) :
    ArrayAdapter<Film>(context, 0, films) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(R.layout.item_film, parent, false)

        val film = getItem(position)

        val image = view.findViewById<ImageView>(R.id.film_image)
        val title = view.findViewById<TextView>(R.id.film_title)
        val director = view.findViewById<TextView>(R.id.film_director)

        film?.let {
            image.setImageResource(it.imageResId)
            title.text = it.title
            director.text = it.director
        }

        return view
    }
}