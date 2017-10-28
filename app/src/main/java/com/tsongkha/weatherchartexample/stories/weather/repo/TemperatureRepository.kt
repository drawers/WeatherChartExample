package com.tsongkha.weatherchartexample.stories.weather.repo

import io.reactivex.Observable
import org.threeten.bp.ZonedDateTime


/**
 * Created by rawsond on 17/09/17.
 */
interface TemperatureRepository {

    fun temperatures() : Observable<TemperatureSample>

    fun temperatures(startInclusive : ZonedDateTime, endInclusive : ZonedDateTime) : Observable<TemperatureSample>
}