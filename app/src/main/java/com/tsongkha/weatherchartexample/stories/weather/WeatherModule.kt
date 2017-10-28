package com.tsongkha.weatherchartexample.stories.weather

import android.content.Context
import com.tsongkha.weatherchartexample.stories.common.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by rawsond on 1/10/17.
 */
@Module
abstract class WeatherModule {

    @Binds
    @ActivityScope
    abstract fun weatherPresenter(presenter: WeatherPresenter) : WeatherContract.Presenter;

    @Module
    @ActivityScope
    companion object {
        @Provides
        @JvmStatic
        fun context(frag: WeatherFragment ) : Context {
            return frag.activity
        }
    }
}