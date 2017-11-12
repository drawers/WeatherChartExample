package com.tsongkha.weatherchartexample.stories.weather.charting

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.DefaultValueFormatter
import com.tsongkha.weatherchartexample.R

/**
 * Created by rawsond on 24/09/17.
 *
 * Decorates a LineChart
 *
 * We stop using dependency injection at the level of the android.view.View since it is not feasible
 * to inject all of the parameters of the View.
 */
class WeatherChart(val delegate : LineChart) {

    fun setData(entries: List<Entry>, labels : List<String>) {
        delegate.clear()

        with(LineDataSet(entries, delegate.context.getString(R.string.dataset_label))) {
            valueFormatter = DefaultValueFormatter(0)
            delegate.data = LineData(this)
        }
    }
}