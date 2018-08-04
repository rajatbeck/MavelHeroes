package com.android.pokemonapp.di.component

import android.app.Application
import com.android.pokemonapp.PokemonApp
import com.android.pokemonapp.di.module.AppModule
import com.android.pokemonapp.di.module.NetModule
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