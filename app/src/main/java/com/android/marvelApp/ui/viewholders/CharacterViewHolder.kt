package com.android.marvelApp.ui.viewholders

import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.marvelApp.R
import com.android.marvelApp.data.remote.Result
import kotlinx.android.synthetic.main.character_row_view.view.*

public class CharacterViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.character_row_view, parent, false)
){
    fun bindTo(result:Result?){
        result?.let {
            itemView.tvCharacterName.text = it.name
        }
    }

}