package com.android.marvelApp.data.remote

data class Response<out T>(
        val status: Int,
        val data: T? = null,
        val error: Throwable? = null
)