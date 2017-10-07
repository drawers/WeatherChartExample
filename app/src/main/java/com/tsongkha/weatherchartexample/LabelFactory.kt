package com.tsongkha.weatherchartexample

import javax.inject.Inject

/**
 * Created by rawsond on 27/09/17.
 */
class LabelFactory @Inject constructor(private val formatter : SimpleTimeFormatter) {

    fun create(sample: TemperatureSample) : String {
        return formatter.format(sample.zdt.toLocalTime())
    }
}