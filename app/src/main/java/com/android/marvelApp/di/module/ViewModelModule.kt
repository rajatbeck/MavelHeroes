package com.android.marvelApp.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.android.marvelApp.di.ViewModelFactory
import com.android.marvelApp.di.ViewModelKey
import com.android.marvelApp.ui.character.CharacterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Suppress("unused")
@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun bindReposModel(characterViewModel: CharacterViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}