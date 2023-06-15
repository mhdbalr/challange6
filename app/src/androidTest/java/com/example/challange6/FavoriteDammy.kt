package com.example.challange6

import com.example.challange6.room.FavoritNote

object FavoriteDammy {
    fun generateDummyFavourite():List<FavoritNote>{
        val favoriteList = ArrayList<FavoritNote>()
        for (i in 0..5){
            val favorite = FavoritNote(
                id = i,
                title = "title $i",
                tanggal = "2022-03-0$i",
                poster_path = "/$i.jpg",
                overview = "overview $i"
            )
            favoriteList.add(favorite)
        }
        return favoriteList
    }
}