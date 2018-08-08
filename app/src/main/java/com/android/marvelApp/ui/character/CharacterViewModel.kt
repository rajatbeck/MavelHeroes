package com.android.marvelApp.ui.character

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.android.marvelApp.data.remote.CharacterListDataSource
import com.android.marvelApp.data.remote.Result
import com.android.marvelApp.data.repository.Repository
import com.android.marvelApp.schedulers.BaseScheduler
import com.android.marvelApp.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class CharacterViewModel @Inject constructor(private val repository: Repository,
                                             private val scheduler: BaseScheduler) : BaseViewModel<Int>() {

    private var characterSourceFactory: CharacterDataSourceFactory
    private val compositeDisposable = CompositeDisposable()
    var result: LiveData<PagedList<Result>>

    fun getResults() = characterSourceFactory.characterListDataSource.value
    fun retry() = characterSourceFactory.characterListDataSource.value?.retry()

    init {

        val config = PagedList.Config.Builder()
                .setInitialLoadSizeHint(20)
                .setPageSize(20)
                .setEnablePlaceholders(false)
                .setPrefetchDistance(10)
                .build()

        characterSourceFactory = CharacterDataSourceFactory(repository, scheduler, compositeDisposable)
        result = LivePagedListBuilder<Int, Result>(characterSourceFactory, config).build()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    class CharacterDataSourceFactory(
            private val repository: Repository,
            private val baseScheduler: BaseScheduler,
            private val compositeDisposable: CompositeDisposable) : DataSource.Factory<Int, Result>() {

        val characterListDataSource = MutableLiveData<CharacterListDataSource>();

        override fun create(): DataSource<Int, Result> {
            val result = CharacterListDataSource(repository, baseScheduler, compositeDisposable);
            characterListDataSource.postValue(result)
            return result
        }

    }

}