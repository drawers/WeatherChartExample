package com.tsongkha.weatherchartexample

import dagger.Binds
import dagger.Module

/**
 * Created by rawsond on 1/10/17.
 */
@Module
abstract class WeatherModule {

    @Binds
    @ActivityScope
    abstract fun weatherPresenter(presenter: WeatherPresenter) : WeatherContract.Presenter;
}