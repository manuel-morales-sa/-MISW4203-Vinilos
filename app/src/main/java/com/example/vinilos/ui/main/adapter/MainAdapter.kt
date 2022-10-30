package com.example.vinilos.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.vinilos.data.model.albumResponse
import com.vinylsMobile.vinylsapplication.databinding.ItemLayoutBinding
import com.example.vinilos.ui.main.view.DetailAlbumActivity

const val ID = "id"

class MainAdapter (private val albums: ArrayList<albumResponse>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    lateinit var context : Context


    class DataViewHolder(binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val bindPar = binding;
        fun bind(album: albumResponse) {
            bindPar.root.apply {
                bindPar.textViewAlbumTitle.text = album.name
                bindPar.textViewDisquera.text = album.recordLabel
                Glide.with(bindPar.imageViewAlbum.context)
                    .load(album.cover)
                    .into(bindPar.imageViewAlbum)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        context = parent.context
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindPar.root.setOnClickListener {
            //Log.d("hola"," mundo")
            val intent = Intent(context, DetailAlbumActivity::class.java).apply {
                putExtra(ID, albums[position].id.toString())
            }

            context.startActivity(intent)

        }

        holder.bind(albums[position])
    }

    fun addAlbums(albums: List<albumResponse>) {
        this.albums.apply {
            clear()
            addAll(albums)
        }

    }
}