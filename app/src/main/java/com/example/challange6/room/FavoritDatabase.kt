package com.example.challange6.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Suppress("unused")
@Database(
    entities = [FavoritNote::class],
    version = 2
)

abstract class FavoritDatabase : RoomDatabase() {

    abstract fun favoritDao() : FavoritDao

    companion object{
        private var INSTANCE : FavoritDatabase? = null

        fun getInstance(context : Context): FavoritDatabase? {
            if (INSTANCE == null){
                synchronized( FavoritDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        FavoritDatabase::class.java,"favorit.db").build()
                }
            }
            return INSTANCE
        }

    }

}