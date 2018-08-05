package com.android.marvelApp.di.module

import com.android.marvelApp.di.FragmentScoped
import com.android.marvelApp.ui.character.CharacterListFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {


    @ContributesAndroidInjector()
    abstract fun characterListFragment():CharacterListFragment

}