package com.tsongkha.weatherchartexample.stories.weather.charting

import android.graphics.BitmapFactory.decodeResource
import android.support.v4.content.ContextCompat.getDrawable
import android.support.v4.content.res.ResourcesCompat.getColor
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
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

    init {
        with(WeatherLineChartRenderer(delegate, delegate.animator, delegate.viewPortHandler, decodeResource(delegate.resources, R.drawable.cloudy))) {
            imageSize = 4
            drawPredicate = { it > 0f && it.toInt() % 8 == 0 }
            delegate.renderer = this
        }
    }

    fun setData(entries: List<Entry>, labels : List<String>) {
        delegate.clear()

        with(LineDataSet(entries, delegate.context.getString(R.string.dataset_label))) {
            setDrawFilled(true)
            setDrawCircles(false)
            setFillDrawable(getDrawable(delegate.context, R.drawable.fade_blue))
            lineWidth = 2f
            color = getColor(delegate.resources, R.color.darkBlue, null)
            valueFormatter = ChartValueFormatter()
                                .apply { formatPredicate = { it.toInt() % 2 == 1 } }
            delegate.data = LineData(this)
        }

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
            axisMinimum = 0f
            axisMaximum = 22f
        }

        with(delegate.axisRight) {
            isEnabled = false
        }

        delegate.description.isEnabled = false
        delegate.isHighlightPerTapEnabled = false
        delegate.isHighlightPerDragEnabled = false
        delegate.disableScroll()
        delegate.animateY(1500)
    }
}