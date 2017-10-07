package com.tsongkha.weatherchartexample

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

/**
 * Created by rawsond on 24/09/17.
 */
class TemperatureChart(val delegate : LineChart) {

    fun setData(entries: List<Entry>, labels : List<String>) {
        delegate.xAxis.valueFormatter = IndexAxisValueFormatter(labels);

        delegate.data = null;
        val lineDataSet = LineDataSet(entries, delegate.context.getString(R.string.dataset_label))
        val lineData = LineData(lineDataSet)

        delegate.data = lineData

        delegate.xAxis.granularity = 1f
        delegate.xAxis.setDrawGridLines(false)
        delegate.xAxis.position = XAxis.XAxisPosition.BOTTOM

        delegate.axisLeft.setDrawGridLines(false)
        delegate.axisRight.setDrawGridLines(false)

        delegate.description.isEnabled = false;
    }
}