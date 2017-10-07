package com.tsongkha.weatherchartexample

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
        val range = max - min
        return min + nextFloat(range)
    }
}