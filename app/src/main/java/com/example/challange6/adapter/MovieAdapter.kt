package com.example.challange6.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challange6.R
import com.example.challange6.databinding.ItemMovieBinding
import com.example.challange6.model.Movie

class MovieAdapter(var listMovie : List<Result>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder (var binding : ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listMovie[position]

        holder.binding.etJudul.text = list.originalTitle
        holder.binding.etTanggal.text = list.releaseDate
        holder.binding.etGenre.text = list.mediaType

        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w200/${list.posterPath}").fitCenter().into(holder.binding.imgMovie)


        holder.binding.cvDetailMoview.setOnClickListener {

            val title = list.title
            val date = list.releaseDate
            val overview = list.overview
            val image = list.posterPath
            val id = list.id

            val movieData = Movie(id,title,overview,date,image)

            val bundle = Bundle()
            bundle.putParcelable("data_movie",movieData)
            it.findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle)

        }
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    fun setDataMovie(list : List<Result>){
        listMovie = list
        notifyDataSetChanged()
    }


}