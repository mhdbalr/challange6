package com.example.challange6

import com.example.challange6.model.Movie
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieTest {
    private lateinit var movie: Movie

    @Before
    fun setUp() {
        // Persiapan sebelum setiap pengujian dilakukan
        val id = 1
        val imagepath = "path/to/image"
        val title = "Movie Title"
        val date = "2023-05-31"
        val overview = "This is a movie overview"

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
        val imagepath = "path/to/image"
        val title = "Movie Title"
        val date = "2023-05-31"
        val overview = "This is a movie overview"

        // Memeriksa apakah nilai-nilai objek DetailMovieTop sesuai dengan yang diharapkan
        Assert.assertEquals(id, movie.id)
        Assert.assertEquals(title, movie.title)
        Assert.assertEquals(date, movie.releaseDate)
        Assert.assertEquals(overview, movie.overview)
        Assert.assertEquals(imagepath, movie.imagePath)
    }
}