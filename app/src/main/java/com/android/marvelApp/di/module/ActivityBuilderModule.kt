package com.android.marvelApp.di.module

import com.android.marvelApp.di.ActivityScoped
import com.android.marvelApp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributesMainActivity(): MainActivity

}