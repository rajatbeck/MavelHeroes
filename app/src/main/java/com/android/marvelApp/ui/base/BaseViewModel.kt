package com.android.marvelApp.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.android.marvelApp.data.remote.Response

abstract class BaseViewModel<T> : ViewModel() {

    val response: MutableLiveData<Response<T>> = MutableLiveData()


}