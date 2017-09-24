package com.tsongkha.weatherchartexample

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by rawsond on 17/09/17.
 */
@Component(modules = arrayOf(TemperatureRepositoryModule::class, AndroidSupportInjectionModule::class))
@Singleton
interface WeatherComponent : AndroidInjector<WeatherApplication> {

    override fun inject(app : WeatherApplication)
}