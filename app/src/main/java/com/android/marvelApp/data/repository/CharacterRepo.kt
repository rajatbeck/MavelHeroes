package com.android.marvelApp.data.repository

import com.android.marvelApp.data.remote.Api
import com.android.marvelApp.data.remote.Result
import com.android.marvelApp.utils.pref.md5
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepo @Inject constructor(private val api: Api) {

    companion object {
        const val pageSize = 20
    }

    private val publicKey: String = "092d5a1c458d3036fe01bdfe3c38631a";
    private val privateKey: String = "fbb7e04d6d37d92506f6a2a4c64eade270afceee";


    fun getCharacters(offset: Int): Flowable<List<Result>> {

        val ts = System.currentTimeMillis()
        val hash = md5(ts.toString() + privateKey + publicKey)
        return api.getCharacters(orderBy = "name", limit = pageSize, offset = offset, ts = ts, hash = hash)
                .toFlowable()
                .map { it.data.results }
    }

}