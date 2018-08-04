package com.android.pokemonapp.di.module

import android.arch.lifecycle.ViewModelProvider
import com.android.pokemonapp.di.ViewModelFactory
import dagger.Binds
import dagger.Module


@Suppress("unused")
@Module
abstract class ViewModelModule {


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}