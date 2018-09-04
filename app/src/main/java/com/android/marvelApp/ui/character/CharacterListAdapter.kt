package com.android.marvelApp.ui.character

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.android.marvelApp.R
import com.android.marvelApp.data.remote.Result
import com.android.marvelApp.ui.viewholders.CharacterViewHolder
import com.android.marvelApp.ui.viewholders.StateLayoutViewHolder
import com.android.marvelApp.utils.ViewState

class CharacterListAdapter(var retry: () -> Unit) : PagedListAdapter<Result, RecyclerView.ViewHolder>(ResultDiffUtil) {

    companion object {

        val ResultDiffUtil: DiffUtil.ItemCallback<Result> = object : DiffUtil.ItemCallback<Result>() {

            override fun areItemsTheSame(oldItem: Result?, newItem: Result?): Boolean = oldItem?.id == newItem?.id

            override fun areContentsTheSame(oldItem: Result?, newItem: Result?): Boolean = oldItem == newItem
        }

    }

    private var state: Int = ViewState.LOADING

    fun setStateValue(state: Int) {

        if (state == this.state) return

        //check before setting state is extra column is showing
        val extraShowing = hasExtra()
        this.state = state


        when (this.state) {
            ViewState.LOADING -> {
                if (extraShowing)
                    notifyItemChanged(itemCount)
                else
                    notifyItemInserted(super.getItemCount())
            }
            ViewState.ERROR -> {
                if (extraShowing)
                    notifyItemChanged(itemCount)
                else
                    notifyItemInserted(super.getItemCount())
            }
            ViewState.SUCCESS -> {
                if (extraShowing) {
                    notifyItemRemoved(itemCount + 1)
                }
            }
            ViewState.COMPLETE -> {
                if (extraShowing) {
                    notifyItemRemoved(itemCount + 1)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return when(viewType){
           ViewState.ERROR -> StateLayoutViewHolder(parent)
           ViewState.LOADING -> StateLayoutViewHolder(parent)
           else -> CharacterViewHolder(parent)
       }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterViewHolder -> holder.bindTo(getItem(position))
            is StateLayoutViewHolder -> when (state) {
                ViewState.LOADING -> holder.showProgressView(R.string.character_progress_text)
                ViewState.ERROR -> holder.showErrorView(R.string.character_error_text, retry)
            }
        }
    }


    override fun getItemViewType(position: Int): Int = if (hasExtra() && position == super.getItemCount()) state else ViewState.SUCCESS


    private fun hasExtra(): Boolean = ViewState.ERROR == state || ViewState.LOADING == state


    override fun getItemCount(): Int = super.getItemCount() + if (hasExtra()) 1 else 0


}