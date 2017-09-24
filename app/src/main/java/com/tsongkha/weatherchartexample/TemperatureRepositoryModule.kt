package com.tsongkha.weatherchartexample

import dagger.Binds
import dagger.Module
import dagger.Provides
import java.util.*

/**
 * Created by rawsond on 24/09/17.
 */
@Module
abstract class TemperatureRepositoryModule {

    @Binds
    @ActivityScope
    abstract fun temperatureRepository(repo : DefaultTemperatureRepository) : TemperatureRepository;

    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun random() : Random {
            return Random(1);
        }

        @JvmStatic
        @Provides
        @ActivityScope
        fun temperatureSampleGenerator(rng : RandomNumberGenerator) : TemperatureSampleGenerator {
            return TemperatureSampleGenerator(rng) //uses default max value
        }
    }

}