package es.ua.eps.filmotecauno

object FilmDataSource {
    val films: MutableList<Film> = mutableListOf()

    init {
        // Película 1
        var f = Film()
        f.title = "Regreso al futuro"
        f.director = "Robert Zemeckis"
        f.imageResId = R.mipmap.ic_launcher
        f.comments = ""
        f.format = Film.FORMAT_DIGITAL
        f.genre = Film.GENRE_SCIFI
        f.imdbUrl = "http://www.imdb.com/title/tt0088763"
        f.year = 1985
        films.add(f)

        // Película 2
        f = Film()
        f.title = "Regreso al futuro II"
        f.director = "Robert Zemeckis"
        f.imageResId = R.mipmap.ic_launcher
        f.format = Film.FORMAT_DIGITAL
        f.genre = Film.GENRE_SCIFI
        f.imdbUrl = "http://www.imdb.com/title/tt0096874"
        f.year = 1989
        films.add(f)

        // Película 3
        f = Film()
        f.title = "Regreso al futuro III"
        f.director = "Robert Zemeckis"
        f.imageResId = R.mipmap.ic_launcher
        f.format = Film.FORMAT_DIGITAL
        f.genre = Film.GENRE_SCIFI
        f.imdbUrl = "http://www.imdb.com/title/tt0099088"
        f.year = 1990
        films.add(f)

        // Película 4
        f = Film()
        f.title = "Los cazafantasmas"
        f.director = "Ivan Reitman"
        f.imageResId = R.mipmap.ic_launcher
        f.format = Film.FORMAT_DVD
        f.genre = Film.GENRE_COMEDY
        f.imdbUrl = "http://www.imdb.com/title/tt0087332"
        f.year = 1984
        films.add(f)
    }
}