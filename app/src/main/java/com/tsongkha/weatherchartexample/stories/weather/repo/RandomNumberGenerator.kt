package com.tsongkha.weatherchartexample.stories.weather.repo

import java.util.*
import javax.inject.Inject

/**
 * Created by rawsond on 17/09/17.
 */
class RandomNumberGenerator @Inject constructor(private val random : Random) {

    fun nextFloat(max: Float) : Float {
        return random.nextFloat() * max
    }

    fun nextFloat(min : Float, max: Float) : Float {
        if (max < min) throw IllegalArgumentException("Max must not be less than min")

        val range = max - min
        return min + nextFloat(range)
    }

    fun nextInt(min : Int, max : Int) : Int {
        if (max < min) throw IllegalArgumentException("Max must not be less than min")

        val range = max - min;
        return min + random.nextInt();
    }
}