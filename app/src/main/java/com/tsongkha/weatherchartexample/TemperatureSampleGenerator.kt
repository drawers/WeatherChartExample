package com.tsongkha.weatherchartexample

import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

/**
 * Created by rawsond on 22/09/17.
 */
class TemperatureSampleGenerator @Inject constructor(val rng : RandomNumberGenerator, val max : Float = 40f) {

    fun generate(zdt : ZonedDateTime) : TemperatureSample {
        return TemperatureSample(zdt, rng.nextFloat(max));
    }
}