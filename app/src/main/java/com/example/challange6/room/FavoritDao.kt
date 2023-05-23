package com.example.challange6.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface FavoritDao {
    @Query("SELECT * FROM FavoritNote")
fun getAllMovieFavorit() : List<FavoritNote>

//    @Insert
//    suspend fun insertFilmFavorites(filmFavorites: FavNote)

    @Insert
    suspend fun addToFavorit(favoritMovie : FavoritNote) : Long
    @Query("SELECT count(*) FROM FavoritNote WHERE FavoritNote.id = :id")
    fun checkMovie(id: Int) : Int
    @Delete
    suspend fun deleteFilmFavorit(filmFavorites: FavoritNote) : Int

}