package com.tsongkha.weatherchartexample.stories.weather

import com.tsongkha.weatherchartexample.stories.common.ActivityScope
import com.tsongkha.weatherchartexample.stories.weather.WeatherFragment
import com.tsongkha.weatherchartexample.stories.weather.WeatherModule
import com.tsongkha.weatherchartexample.stories.weather.repo.TemperatureRepositoryModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rawsond on 24/09/17.
 */
@Module
abstract class WeatherFragmentModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(TemperatureRepositoryModule::class, WeatherModule::class))
    abstract fun weatherFragment() : WeatherFragment
}