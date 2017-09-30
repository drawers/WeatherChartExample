package com.tsongkha.weatherchartexample

import javax.inject.Inject

/**
 * Created by rawsond on 27/09/17.
 */
class LabelFactory @Inject constructor() {

    fun create(sample: TemperatureSample) : String {
        return sample.zdt.toLocalTime().toString();
    }
}