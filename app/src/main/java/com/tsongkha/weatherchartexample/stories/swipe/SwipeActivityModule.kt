package com.tsongkha.weatherchartexample.stories.swipe

import com.tsongkha.weatherchartexample.stories.common.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rawsond on 24/09/17.
 */
@Module
abstract class SwipeActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun swipeActivity() : SwipeActivity
}