package com.android.marvelApp.di.module

import android.app.Application
import android.content.Context
import com.android.marvelApp.PokemonApp
import com.android.marvelApp.schedulers.BaseScheduler
import com.android.marvelApp.schedulers.SchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {


    @Provides
    @Singleton
    fun provideScheduler(): BaseScheduler {
        return SchedulerProvider()
    }

}