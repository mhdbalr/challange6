package com.example.challange6.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challange6.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritFragment : Fragment() {
    private lateinit var binding: FragmentFavoritBinding
    private lateinit var favoriteAdapter: FavoritAdapter
    private lateinit var favoritViewModel: FavoritViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavoritBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    override fun onStart() {
        super.onStart()
        favoritViewModel = ViewModelProvider(this)[FavoritViewModel::class.java]
        favoritViewModel.getFavoriteMovie().observe(this) {
            favoriteAdapter = FavoritAdapter(it)
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.rvFavMovie.layoutManager = layoutManager
            binding.rvFavMovie.adapter = FavoritAdapter(it)
        }


    }

}