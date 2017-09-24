package com.tsongkha.weatherchartexample

import java.util.*

/**
 * Created by rawsond on 17/09/17.
 */
class RandomNumberGenerator(val random: Random) {

    fun nextFloat(max: Float) : Float {
        return random.nextFloat() * max;
    }
}