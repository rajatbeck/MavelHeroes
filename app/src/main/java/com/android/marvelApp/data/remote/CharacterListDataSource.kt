package com.android.marvelApp.data.remote

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.ItemKeyedDataSource
import com.android.marvelApp.data.repository.Repository
import com.android.marvelApp.schedulers.BaseScheduler
import com.android.marvelApp.utils.ViewState
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

class CharacterListDataSource @Inject constructor(
        private val repository: Repository,
        private val scheduler: BaseScheduler,
        private val compositeDisposable: CompositeDisposable
) : ItemKeyedDataSource<Int, Result>() {


    var page = 1
    var response = MutableLiveData<Response<Int>>()
    private var retryCompletable: Completable? = null

    open fun retry() {
        retryCompletable?.let {
            it.subscribe({ }, { throwable -> Timber.e(throwable.message) })
        }
    }

    private fun setRetry(action: Action?) {
        if (action == null) {
            this.retryCompletable = null
        } else {
            this.retryCompletable = Completable.fromAction(action)
        }
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Result>) = fetch(page,callback)


    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Result>) = fetch(page,callback)


    // Todo
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Result>) {}

    override fun getKey(item: Result): Int = item.id


    private fun fetch(offset: Int, callback: LoadCallback<Result>) {

        compositeDisposable.add(repository.characterRepo.getCharacters(page)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnSubscribe { response.postValue(Response(ViewState.LOADING)) }
                .subscribeBy(
                        onNext = {
                            response.postValue(Response(ViewState.SUCCESS))
                            callback.onResult(it)
                            page++;
                            setRetry(null)

                        },
                        onError = {
                            response.postValue(Response(ViewState.ERROR, error = it))
                            setRetry(Action { fetch(offset, callback) })
                        }
                )
        )
    }

}