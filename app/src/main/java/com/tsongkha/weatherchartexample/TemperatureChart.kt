package com.tsongkha.weatherchartexample

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import io.reactivex.Observable

/**
 * Created by rawsond on 24/09/17.
 */
class TemperatureChart(val delegate : LineChart) {

    fun setData(samples: Observable<TemperatureSample>) {
        var entries : List<Entry> = samples.blockingIterable()
                .mapIndexed{ index, temperatureSample -> toEntry(index, temperatureSample)}
        val set : ILineDataSet = LineDataSet(entries, "temperature")
        val data : LineData = LineData(set)
        delegate.data = data;
    }

    fun toEntry(index : Int, sample : TemperatureSample) : Entry {
        return Entry(index.toFloat(), sample.temperature);
    }

}