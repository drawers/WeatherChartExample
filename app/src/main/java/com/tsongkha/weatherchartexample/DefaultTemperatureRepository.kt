package com.tsongkha.weatherchartexample

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable
import org.threeten.bp.Duration
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

/**
 * Created by rawsond on 17/09/17.
 */
class DefaultTemperatureRepository @Inject constructor(private val generator : TemperatureSampleGenerator) : TemperatureRepository {

    override fun temperatures(): Observable<TemperatureSample> {
        return temperatures(ZonedDateTime.now().minusDays(50), ZonedDateTime.now());
    }

    override fun temperatures(startInclusive: ZonedDateTime, endInclusive: ZonedDateTime): Observable<TemperatureSample> {
        return between(startInclusive, endInclusive)
                .map(generator::generate)
                .toObservable()
    }


    fun between(startInclusive: ZonedDateTime, endInclusive: ZonedDateTime): List<ZonedDateTime> {
        val hours = Duration.between(startInclusive, endInclusive).toHours();
        return LongProgression.fromClosedRange(0, hours + 1, 1)
                .map(startInclusive::plusHours)
    }
}