package com.tsongkha.weatherchartexample

import android.graphics.Color
import android.support.v4.content.ContextCompat
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

        delegate.data = null;
        val lineDataSet = LineDataSet(entries, delegate.context.getString(R.string.dataset_label))

        with(lineDataSet) {
            setDrawFilled(true)
            setDrawCircles(false)
            setFillDrawable(ContextCompat.getDrawable(delegate.context, R.drawable.fade_blue))
            mode = LineDataSet.Mode.HORIZONTAL_BEZIER
            lineWidth = 4f
        }


        val lineData = LineData(lineDataSet)

        delegate.data = lineData
        with(delegate.data) {

        }

        with(delegate.xAxis) {
            valueFormatter = IndexAxisValueFormatter(labels);
            granularity = 1f
            setDrawGridLines(false)
            position = XAxis.XAxisPosition.BOTTOM
        }

        with(delegate.axisLeft) {
            setDrawGridLines(false)
            axisMinimum = 0f
        }

        with(delegate.axisRight) {
            isEnabled = false
        }

        delegate.description.isEnabled = false;
    }
}