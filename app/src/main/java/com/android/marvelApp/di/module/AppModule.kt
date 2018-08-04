package com.android.marvelApp.di.module

import android.app.Application
import android.content.Context
import com.android.marvelApp.PokemonApp
import dagger.Binds
import dagger.Module


@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: PokemonApp): Context

}