package com.tsongkha.weatherchartexample

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by rawsond on 24/09/17.
 */
@Module
abstract class TemperatureRepositoryModule {

    @Binds
    @Singleton
    abstract fun temperatureRepository(repo : DefaultTemperatureRepository) : TemperatureRepository;
}