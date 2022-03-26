package com.technicalassigments.moviewapp.ui.main.view

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.technicalassigments.moviewapp.ui.main.model.GenreMovie
import com.technicalassigments.moviewapp.R
import com.technicalassigments.moviewapp.databinding.ListKategoriItemBinding
import com.technicalassigments.moviewapp.ui.main.callback.GetSelectedGenre

class GenreViewHolder(private val binding: ListKategoriItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val selectedGenre = arrayListOf<Int>()
    fun onBind(genre: GenreMovie, onGetSelectedGenre: GetSelectedGenre) {
        binding.tvGenre.text = genre.name
        if (genre.id in selectedGenre) {
            binding.llGenre.setBackgroundColor(
                ContextCompat.getColor(itemView.context, R.color.white)
            )
        } else {
            binding.llGenre.setBackgroundColor(
                ContextCompat.getColor(itemView.context, R.color.onsurface)
            )
        }
        itemView.setOnClickListener {
            onClickGenre(genre, onGetSelectedGenre)
        }
    }

    private fun onClickGenre(genre: GenreMovie, onGetSelectedGenre: GetSelectedGenre) {
        if (genre.id in selectedGenre) {
            selectedGenre.remove(genre.id)
            binding.llGenre.setBackgroundColor(
                ContextCompat.getColor(itemView.context, R.color.onsurface)
            )
            genre.id.let { id ->
                onGetSelectedGenre.onGetSelectedGenre(id)
            }
        } else {
            genre.id.let { it1 -> selectedGenre.add(it1) }
            binding.llGenre.setBackgroundColor(
                ContextCompat.getColor(itemView.context, R.color.white)
            )
            genre.id.let { id ->
                onGetSelectedGenre.onGetSelectedGenre(id)
            }
        }
    }
}
