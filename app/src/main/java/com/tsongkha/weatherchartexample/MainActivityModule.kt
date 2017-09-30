package com.tsongkha.weatherchartexample

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rawsond on 24/09/17.
 */
@Module
abstract class MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(TemperatureRepositoryModule::class, WeatherModule::class))
    abstract fun mainActivity() : MainActivity
}