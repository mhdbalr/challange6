package com.example.challange6

import com.example.challange6.model.Movie
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieTest {
    private lateinit var movie: Movie

    @Before
    fun setUp() {
        // Persiapan sebelum setiap pengujian dilakukan
        val id = 1
        val imagepath = "path/image/to"
        val title = "Movie Name"
        val date = "2023-09-16"
        val overview = "The movie overview"

        // Membuat objek DetailMovieTop dengan nilai-nilai yang diberikan
        movie = Movie(id, title, overview, date, imagepath)
    }

    @After
    fun tearDown() {
        // Membersihkan setelah setiap pengujian selesai
    }

    @Test
    fun testMovie() {
        // Persiapan data yang diperlukan untuk pengujian
        val id = 1
        val imagepath = "path/image/to"
        val title = "Movie Name"
        val date = "2023-09-16"
        val overview = "The movie overview"

        // Memeriksa apakah nilai-nilai objek DetailMovieTop sesuai dengan yang diharapkan
        assertEquals(id, movie.id)
        assertEquals(title, movie.title)
        assertEquals(date, movie.releaseDate)
        assertEquals(overview, movie.overview)
        assertEquals(imagepath, movie.imagePath)
    }
}