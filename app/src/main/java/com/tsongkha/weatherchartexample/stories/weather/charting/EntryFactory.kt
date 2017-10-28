package com.tsongkha.weatherchartexample.stories.weather.charting

import com.github.mikephil.charting.data.Entry
import com.tsongkha.weatherchartexample.stories.weather.repo.TemperatureSample
import javax.inject.Inject

/**
 * Created by rawsond on 27/09/17.
 */
class EntryFactory @Inject constructor() {

    fun create(index: Int, sample : TemperatureSample) : Entry {
        return Entry(index.toFloat(), sample.temperature);
    }
}