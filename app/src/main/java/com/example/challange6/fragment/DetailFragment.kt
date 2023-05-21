package com.example.challange6.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.challange6.R
import com.example.challange6.model.Movie
import com.example.challange6.viewmodel.FavoritViewModel
import com.example.challange6.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment(var favoritViewModel: FavoritViewModel) : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    lateinit var filmViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritViewModel = ViewModelProvider(this).get(FavoritViewModel::class.java)

        // pengambilan data
        val list = arguments?.getParcelable<Movie>("data_movie") as Movie
        val title = list.title
        val date = list.releaseDate
        val overview = list.overview
        val imagepath = list.imagePath
        val id = list.id


        binding.tvTitle.text = title
        binding.tvTglRelease.text = date
        binding.tvDesc.text = overview

        Glide.with(view.context).load("https://image.tmdb.org/t/p/w780${imagepath}").into(binding.imgMovie)

        binding.imgFav.setOnClickListener {
            favoritViewModel.insertMovie(id, title, date, imagepath)
            Toast.makeText(context, "Berhasil di tambah", Toast.LENGTH_SHORT).show()
        }

    }




}