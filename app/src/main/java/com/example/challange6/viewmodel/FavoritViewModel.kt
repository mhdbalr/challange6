package com.example.challange6.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.challange6.room.FavoritDao
import com.example.challange6.room.FavoritDatabase
import com.example.challange6.room.FavoritNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused")
@HiltViewModel
class FavoritViewModel @Inject constructor(app: Application): AndroidViewModel(app){
    private var favDao : FavoritDao?=null
    private var favDb : FavoritDatabase?=null

    private var liveDataListfav: MutableLiveData<List<FavoritNote>> = MutableLiveData()

    init {
        getAllMoviePopular()
    }

    fun getliveDataMoviefav(): MutableLiveData<List<FavoritNote>> {
        return  liveDataListfav
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getAllMoviePopular() {

        GlobalScope.launch {
            val favdao = FavoritDatabase.getInstance(getApplication())!!.favoritDao()
            val listNote = favdao.getAllMovieFavorit()
            liveDataListfav.postValue(listNote)

        }
    }

    suspend fun delete(favoritMovie : FavoritNote) {
        val dataDao = FavoritDatabase.getInstance(getApplication())!!.favoritDao()
        dataDao.deleteFilmFavorit(favoritMovie)
        getAllMoviePopular()
    }

    suspend fun insert(favoritMovie : FavoritNote){
        val dataDao = FavoritDatabase.getInstance(getApplication())!!.favoritDao()
        dataDao.addToFavorit(favoritMovie)
        getAllMoviePopular()
    }

    fun check(id: Int){
        val dataDao = FavoritDatabase.getInstance(getApplication())!!.favoritDao()
        dataDao.checkMovie(id)
        getAllMoviePopular()
    }


}