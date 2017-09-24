package com.tsongkha.weatherchartexample

import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by rawsond on 17/09/17.
 */
class WeatherApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this);
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val weatherComponent : WeatherComponent = DaggerWeatherComponent.builder().build();
        weatherComponent.inject(this);
        return weatherComponent;
    }
}