package com.tsongkha.weatherchartexample.stories.weather.repo

import org.threeten.bp.ZonedDateTime

/**
 * Created by rawsond on 17/09/17.
 */
data class TemperatureSample(val zdt : ZonedDateTime, val temperature : Float)