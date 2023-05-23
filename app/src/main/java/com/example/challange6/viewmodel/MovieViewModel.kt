package com.example.challange6.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challange6.model.ResponseMovie
import com.example.challange6.network.ResultApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@Suppress("MemberVisibilityCanBePrivate", "JoinDeclarationAndAssignment")
@HiltViewModel
class MovieViewModel @Inject constructor(private var api : ResultApi): ViewModel() {
    lateinit var liveDataMovie : MutableLiveData<List<com.example.challange6.model.Result>>
    private lateinit var liveDetailMovie : MutableLiveData<ResponseMovie>

    private val key = "2b66746a9a705b1acae562b4b4d07704"

    init {
        liveDataMovie = MutableLiveData()
        liveDetailMovie = MutableLiveData()
    }

    fun getDataFilm() : MutableLiveData<List<com.example.challange6.model.Result>> {
        return liveDataMovie
    }
    fun getDetailMovie() : MutableLiveData<ResponseMovie> {
        return liveDetailMovie
    }

    fun getApiMovie() {
        api.getTrendingMovie(key).enqueue(object :
            Callback<ResponseMovie> {
            @SuppressLint("NullSafeMutableLiveData")
            override fun onResponse(
                call: Call<ResponseMovie>,
                response: Response<ResponseMovie>
            ) {
                if (response.isSuccessful){
                    liveDataMovie.postValue(response.body()!!.results)
                } else {
                    liveDataMovie.postValue(null)
                }
            }

            @SuppressLint("NullSafeMutableLiveData")
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                liveDataMovie.postValue(null)
            }

        })
    }

}