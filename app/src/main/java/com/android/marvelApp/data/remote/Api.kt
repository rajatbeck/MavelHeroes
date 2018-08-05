package com.android.marvelApp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    companion object {
        const  val Key = "092d5a1c458d3036fe01bdfe3c38631a"
    }

    @GET("v1/public/characters?orderBy=name&limit={limit}&offset={offset}&apikey=$Key")
    fun getCharacters(@Query("limit") limit: Int, @Query("offset") offset: Int)

}