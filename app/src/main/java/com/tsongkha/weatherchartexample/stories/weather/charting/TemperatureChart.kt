package com.tsongkha.weatherchartexample.stories.weather.charting

import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.DefaultValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.tsongkha.weatherchartexample.R

/**
 * Created by rawsond on 24/09/17.
 */
class TemperatureChart(val delegate : LineChart) {

    fun setData(entries: List<Entry>, labels : List<String>) {

        delegate.data = null;
        val lineDataSet = LineDataSet(entries, delegate.context.getString(R.string.dataset_label))

        with(lineDataSet) {
            setDrawFilled(true)
            setDrawCircles(false)
            setFillDrawable(ContextCompat.getDrawable(delegate.context, R.drawable.fade_blue))
            mode = LineDataSet.Mode.CUBIC_BEZIER
            lineWidth = 1f
            color = ResourcesCompat.getColor(delegate.resources, R.color.darkBlue, null)
            valueFormatter = DefaultValueFormatter(0)
        }

        val lineData = LineData(lineDataSet)
        delegate.data = lineData

        with(delegate.xAxis) {
            valueFormatter = IndexAxisValueFormatter(labels);
            granularity = 1f
            setDrawLabels(true)
            setDrawGridLines(false)
            position = XAxis.XAxisPosition.BOTTOM
        }

        with(delegate.axisLeft) {
            setDrawGridLines(false)
            setDrawAxisLine(false)
            setDrawLabels(false)
            axisMinimum = 12f
            axisMaximum = 25f
        }

        with(delegate.axisRight) {
            isEnabled = false
        }

        delegate.description.isEnabled = false
        delegate.isHighlightPerTapEnabled = false
        delegate.isHighlightPerDragEnabled = false
        delegate.animateY(1500)
    }
}