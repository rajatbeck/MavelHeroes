package com.android.marvelApp.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    companion object {
        const val Key = "092d5a1c458d3036fe01bdfe3c38631a"
    }

    @GET("/v1/public/characters")
    fun getCharacters(
            @Query("ts") ts:Long,
            @Query("apikey") apikey: String = "092d5a1c458d3036fe01bdfe3c38631a",
            @Query("hash") hash:String,
            @Query("orderBy") orderBy: String = "name",
            @Query("limit") limit: Int = 20,
            @Query("offset") offset: Int=0
    ): Single<CharacterResponse>

}