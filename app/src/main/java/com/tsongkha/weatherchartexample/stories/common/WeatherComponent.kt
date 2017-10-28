package com.tsongkha.weatherchartexample.stories.common

import com.tsongkha.weatherchartexample.stories.weather.WeatherFragmentModule
import com.tsongkha.weatherchartexample.stories.swipe.SwipeActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by rawsond on 17/09/17.
 */
@Component(modules = arrayOf(SwipeActivityModule::class, WeatherFragmentModule::class, AndroidSupportInjectionModule::class))
@Singleton
interface WeatherComponent : AndroidInjector<WeatherApplication> {

    override fun inject(app : WeatherApplication)
}