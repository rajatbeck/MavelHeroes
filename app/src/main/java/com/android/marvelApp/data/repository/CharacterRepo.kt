package com.android.marvelApp.data.repository

import com.android.marvelApp.data.remote.Api
import com.android.marvelApp.data.remote.Result
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepo @Inject constructor(private val api: Api){

    companion object {
        const val pageSize = 20
    }

    fun getCharacters(offset:Int):Flowable<List<Result>>{

       return api.getCharacters(pageSize,offset)
                .toFlowable()
                .map {  it.data.results }
    }

}