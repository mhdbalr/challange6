package com.example.challange6.di

import android.app.Application
import androidx.room.Room
import com.example.challange6.room.FavoritDao
import com.example.challange6.room.FavoritDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused")
@Module
@InstallIn(SingletonComponent::class)
class HiltModule {
    @Singleton
    @Provides
    fun provideDatabase(app: Application): FavoritDatabase {
        return Room.databaseBuilder(app, FavoritDatabase::class.java, "favorite_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideFavoriteDao(database: FavoritDatabase): FavoritDao {
        return database.favoritDao()
    }
}