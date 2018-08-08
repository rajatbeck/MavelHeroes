package com.android.marvelApp.ui.character

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.marvelApp.R
import com.android.marvelApp.data.remote.Result
import com.android.marvelApp.data.repository.Repository
import dagger.android.support.DaggerFragment

import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.fragment_character_list.*
import javax.inject.Inject


public class CharacterListFragment : DaggerFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var repository: Repository

    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var characterListAdapter: CharacterListAdapter




    companion object {

        fun getInstance(): CharacterListFragment = CharacterListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        characterViewModel = ViewModelProviders.of(requireActivity(), viewModelFactory)[CharacterViewModel::class.java]
        characterListAdapter = CharacterListAdapter({ characterViewModel.retry() })


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCharacterList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = characterListAdapter
        }

        characterViewModel.result.observe(this, Observer<PagedList<Result>> { characterListAdapter.submitList(it) })

    }
}