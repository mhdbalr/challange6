package com.example.challange6.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challange6.adapter.FavoritAdapter
import com.example.challange6.databinding.FragmentFavoritBinding
import com.example.challange6.room.FavoritDatabase
import com.example.challange6.room.FavoritNote
import com.example.challange6.viewmodel.FavoritViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritFragment : Fragment() {
    private lateinit var binding: FragmentFavoritBinding
    private lateinit var favoriteAdapter: FavoritAdapter
    private lateinit var favoritViewModel: FavoritViewModel
    private var favDatabase: FavoritDatabase? = null


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

        favDatabase = FavoritDatabase.getInstance(requireContext())

        favoritViewModel = ViewModelProvider(this)[FavoritViewModel::class.java]

        favoriteAdapter = FavoritAdapter(requireActivity(), ArrayList())

        binding.rvFavMovie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvFavMovie.adapter = favoriteAdapter

        favoritViewModel = ViewModelProvider(this)[FavoritViewModel::class.java]
        favoritViewModel.getliveDataMoviefav().observe(viewLifecycleOwner) {
            favoriteAdapter.setMovie(it as ArrayList<FavoritNote>)
        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            val favorit = favDatabase?.favoritDao()!!.getAllMovieFavorit()
            activity?.runOnUiThread {
                favoriteAdapter = FavoritAdapter(requireActivity(), favorit)
                binding.rvFavMovie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvFavMovie.adapter = favoriteAdapter


            }
        }
    }

}