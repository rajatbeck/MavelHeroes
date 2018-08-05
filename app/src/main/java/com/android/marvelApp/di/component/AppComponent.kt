package com.android.marvelApp.di.component

import android.app.Application
import com.android.marvelApp.PokemonApp
import com.android.marvelApp.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetModule::class,
    ActivityBuildersModule::class


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