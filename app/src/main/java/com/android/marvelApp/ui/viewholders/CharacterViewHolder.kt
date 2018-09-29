package com.android.marvelApp.ui.viewholders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.marvelApp.GlideApp
import com.android.marvelApp.R
import com.android.marvelApp.data.remote.Result
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.character_row_view.view.*

public class CharacterViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.character_row_view, parent, false)
) {
    fun bindTo(result: Result?) {
        result?.let {
            GlideApp.with(itemView)
                    .load("${it.thumbnail.path}.${it.thumbnail.extension}")
                    .centerCrop()
                    .optionalCircleCrop()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(itemView.ivAvatar);
            itemView.tvCharacterName.text = it.name

        }
    }

}