package com.android.marvelApp.di.component

import android.app.Application
import com.android.marvelApp.PokemonApp
import com.android.marvelApp.di.module.AppModule
import com.android.marvelApp.di.module.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetModule::class
])
interface AppComponent : AndroidInjector<PokemonApp> {

   override fun inject(pokemonApp: PokemonApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


}