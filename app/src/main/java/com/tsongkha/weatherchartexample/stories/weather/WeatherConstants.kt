package com.tsongkha.weatherchartexample.stories.weather

import org.threeten.bp.LocalDate

/**
 * Created by rawsond on 24/10/17.
 */
class WeatherConstants {

    companion object {
        @JvmStatic val VIEWPAGER_POSITION = "VIEWPAGER_POSITION"

        @JvmStatic val LOCAL_DATE = "LOCAL_DATE"

        @JvmStatic val EPOCH = LocalDate.of(2017, 1,1)

        @JvmStatic val DAY_COUNT = 100
    }
}