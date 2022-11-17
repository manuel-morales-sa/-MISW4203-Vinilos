package com.example.vinilos.ui.main.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.vinilos.data.model.CollectorResponse
import com.vinylsMobile.vinylsapplication.R
import com.vinylsMobile.vinylsapplication.databinding.ItemLayoutBinding

class CollectorAdapter(
    private val collectors: ArrayList<CollectorResponse>
) : RecyclerView.Adapter<CollectorAdapter.DataViewHolder>() {

    lateinit var context: Context

    class DataViewHolder(binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        private val bindPar = binding
        fun bind(collector: CollectorResponse) {
            bindPar.root.apply {
                bindPar.textViewAlbumName.text = collector.name
                bindPar.textAlbumRecord.text = collector.email
                Glide.with(bindPar.imageViewAvatar.context)
                    .load(R.drawable.ic_baseline_construction_collector)
                    .error(R.drawable.ic_baseline_construction_collector).placeholder(R.drawable.ic_baseline_construction_collector)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(bindPar.imageViewAvatar)
                bindPar.imageViewAvatar.setColorFilter(
                    Color.rgb(93, 193, 185),
                    PorterDuff.Mode.SRC_ATOP
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        context = parent.context
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = collectors.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        holder.bind(collectors[position])
    }

    fun addCollectors(collectors: List<CollectorResponse>) {
        this.collectors.apply {
            clear()
            addAll(collectors)
        }

    }
}